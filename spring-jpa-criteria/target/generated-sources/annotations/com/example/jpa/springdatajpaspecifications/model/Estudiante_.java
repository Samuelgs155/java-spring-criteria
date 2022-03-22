package com.example.jpa.springdatajpaspecifications.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estudiante.class)
public abstract class Estudiante_ {

	public static volatile SingularAttribute<Estudiante, Date> createdDate;
	public static volatile SingularAttribute<Estudiante, String> name;
	public static volatile SingularAttribute<Estudiante, Integer> id;

	public static final String CREATED_DATE = "createdDate";
	public static final String NAME = "name";
	public static final String ID = "id";

}

