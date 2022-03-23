package com.apring.jpa.criteria.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tarjeta.class)
public abstract class Tarjeta_ {

	public static volatile SingularAttribute<Tarjeta, Date> caducidad;
	public static volatile SingularAttribute<Tarjeta, Long> numero;
	public static volatile SingularAttribute<Tarjeta, Socio> socio;

	public static final String CADUCIDAD = "caducidad";
	public static final String NUMERO = "numero";
	public static final String SOCIO = "socio";

}

