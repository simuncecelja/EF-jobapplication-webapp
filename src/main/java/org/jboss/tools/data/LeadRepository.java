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
package org.jboss.tools.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.model.Lead;

import java.util.List;

@ApplicationScoped
public class LeadRepository {

	
    @Inject
    private EntityManager em;


    public List<Lead> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Lead> criteria = cb.createQuery(Lead.class);
        Root<Lead> lead = criteria.from(Lead.class);
        criteria.select(lead).orderBy(cb.asc(lead.get("name")));
        return em.createQuery(criteria).getResultList();
    }
    
    public Lead findById(Long id) {
        return em.find(Lead.class, id);
    }

    public Lead findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Lead> criteria = cb.createQuery(Lead.class);
        Root<Lead> lead = criteria.from(Lead.class);
        criteria.select(lead).where(cb.equal(lead.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }
    
    public List<Lead> findByName(String name) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Lead> criteria = cb.createQuery(Lead.class);
        Root<Lead> lead = criteria.from(Lead.class);
        
        criteria.select(lead)
        .where(cb.like(cb.lower(lead.<String>get("name")), "%"+name.toLowerCase()+"%"))
        .orderBy(cb.asc(lead.get("name")));
        
        return em.createQuery(criteria).getResultList();
    }
    
    
}
