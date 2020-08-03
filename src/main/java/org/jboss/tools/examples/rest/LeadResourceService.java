/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.tools.examples.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.tools.examples.data.LeadRepository;
import org.jboss.tools.examples.model.Lead;
import org.jboss.tools.examples.service.LeadManager;


@Path("/leads")
@RequestScoped
public class LeadResourceService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private LeadRepository repository;

    @Inject
    LeadManager manager;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lead> lookupMemberByName(@QueryParam("name") String name) {
    	
    	List<Lead> lead;
    	
    	if (name != null) {
    		lead = repository.findByName(name);
    		if (lead == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
		} else {
			lead =repository.findAllOrderedByName();
		}
        return lead;
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertLead(Lead lead) {

        Response.ResponseBuilder builder = null;

        try {
            // Validates lead using bean validation
            validateLead(lead,false);
            manager.insert(lead);

            builder = Response.ok(lead,MediaType.APPLICATION_JSON);
        } catch (ConstraintViolationException ce) {
            // Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
        } catch (ValidationException e) {
            // Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("email", "Email taken");
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLead(Lead lead) {

        Response.ResponseBuilder builder = null;

        try {

            Lead fetchedLead = repository.findById(lead.getId());
            if (fetchedLead == null) {
                throw new WebApplicationException();
            }
            
            if (lead.getEmail().equals(fetchedLead.getEmail())) {
            	validateLead(lead,true);
			}else {
				validateLead(lead,false);
			}
            
            manager.update(lead);

            builder = Response.ok(lead, MediaType.APPLICATION_JSON);
        } catch (ConstraintViolationException ce) {
            // Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
        } catch (ValidationException e) {
            // Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("email", "Email taken");
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (WebApplicationException e) {
            // Handle not found exception
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("lead not found", "Lead with id "+lead.getId()+" has not been found");
            builder = Response.status(Response.Status.NOT_FOUND).entity(responseObj);
        }catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLead(@PathParam("id") long id) {

        Response.ResponseBuilder builder = null;

        try {

            Lead fetchedLead = repository.findById(id);
            if (fetchedLead == null) {
                throw new WebApplicationException();
            }
            manager.delete(fetchedLead);

            builder = Response.ok();
        } catch (WebApplicationException e) {
            // Handle not found exception
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("lead not found", "Lead with id "+id+" has not been found");
            builder = Response.status(Response.Status.NOT_FOUND).entity(responseObj);
        }catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }

    private void validateLead(Lead lead, boolean skipEmailCheck) throws ConstraintViolationException, ValidationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Lead>> violations = validator.validate(lead);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }

        if (skipEmailCheck)
			return;
        
        // Check the uniqueness of the email address
        if (emailAlreadyExists(lead.getEmail())) {
            throw new ValidationException("Unique Email Violation");
        }
    }


    private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }


    public boolean emailAlreadyExists(String email) {
        Lead lead = null;
        try {
        	lead = repository.findByEmail(email);
        } catch (NoResultException e) {
            // ignore
        }
        return lead != null;
    }
}
