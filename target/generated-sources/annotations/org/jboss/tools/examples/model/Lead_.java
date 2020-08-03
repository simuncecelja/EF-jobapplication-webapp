package org.jboss.tools.examples.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lead.class)
public abstract class Lead_ {

	public static volatile SingularAttribute<Lead, String> phoneNumber;
	public static volatile SingularAttribute<Lead, String> countryISOCode;
	public static volatile SingularAttribute<Lead, String> name;
	public static volatile SingularAttribute<Lead, Long> id;
	public static volatile ListAttribute<Lead, LeadVehicleRequirement> leadVehicleRequirement;
	public static volatile SingularAttribute<Lead, String> email;

}

