package com.ifpe.semanainfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.repository.GroupsRepository;

@Service
public class GroupsService {
	
	@Autowired
	private GroupsRepository groupRepository;
	
	public Groups get(Long id) {
		return groupRepository.findById(id).get();
	}

}
