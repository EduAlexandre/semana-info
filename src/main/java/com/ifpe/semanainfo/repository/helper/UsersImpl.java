package com.ifpe.semanainfo.repository.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ifpe.semanainfo.model.UserModel;

public class UsersImpl implements UsersQueries{

	
	@PersistenceContext
	private EntityManager manager;
	
	/*Metodo
	 * Faz uma busca das permissoes que estão no bacno de dados*/
	@Override
	public List<String> permissions(UserModel userModel) {
		
	return manager.createQuery("select distinct p.nome from UserModel u inner join u.groups g inner join g.permissions p where u = :userModel", String.class)
				.setParameter("userModel", userModel)
				.getResultList();
		
	}

}
