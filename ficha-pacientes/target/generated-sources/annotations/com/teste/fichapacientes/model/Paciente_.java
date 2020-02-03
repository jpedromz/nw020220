package com.teste.fichapacientes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, PlanoDeSaude> planoDesaude;
	public static volatile SingularAttribute<Paciente, Especialidade> especialidade;
	public static volatile SingularAttribute<Paciente, Long> id;
	public static volatile SingularAttribute<Paciente, String> nomePaciente;

}

