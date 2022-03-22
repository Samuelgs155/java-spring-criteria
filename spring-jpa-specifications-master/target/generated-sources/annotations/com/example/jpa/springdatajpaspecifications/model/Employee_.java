package com.example.jpa.springdatajpaspecifications.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> firstname;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> department;
	public static volatile SingularAttribute<Employee, String> lastname;

	public static final String FIRSTNAME = "firstname";
	public static final String ID = "id";
	public static final String DEPARTMENT = "department";
	public static final String LASTNAME = "lastname";

}

