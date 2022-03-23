package com.apring.jpa.criteria.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Socio.class)
public abstract class Socio_ {

	public static volatile SingularAttribute<Socio, String> apellidos;
	public static volatile SingularAttribute<Socio, Long> id;
	public static volatile SingularAttribute<Socio, Tarjeta> tarjeta;
	public static volatile SingularAttribute<Socio, String> nombre;
	public static volatile SingularAttribute<Socio, String> dni;

	public static final String APELLIDOS = "apellidos";
	public static final String ID = "id";
	public static final String TARJETA = "tarjeta";
	public static final String NOMBRE = "nombre";
	public static final String DNI = "dni";

}

