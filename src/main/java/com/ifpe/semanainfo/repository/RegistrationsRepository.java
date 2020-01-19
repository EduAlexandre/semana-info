package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.semanainfo.model.Registrations;

public interface RegistrationsRepository extends JpaRepository<Registrations, Integer> {

}
