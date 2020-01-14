package com.ifpe.semanainfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.semanainfo.model.Groups;

public interface GroupsRepository extends JpaRepository<Groups, Long> {

	Optional<Groups> findById(Long id);



}
