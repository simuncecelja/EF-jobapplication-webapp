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
package org.jboss.tools.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.model.Lead;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class LeadManager {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void insert(Lead lead) throws Exception {
        log.info("Inserting " + lead.getName());
        em.persist(lead);
    }
    
    public void update(Lead lead) throws Exception {
        log.info("Updating lead with ID:" + lead.getId());
        em.merge(lead);
    }
    
    public void delete(Lead lead) throws Exception {
        log.info("Deleating lead with ID:" + lead.getId());
        em.remove(em.contains(lead) ? lead : em.merge(lead));
    }
    
    

    
}
