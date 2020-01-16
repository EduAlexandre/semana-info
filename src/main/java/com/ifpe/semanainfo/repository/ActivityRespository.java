package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.semanainfo.model.Activity;

public interface ActivityRespository extends JpaRepository<Activity, Integer> {

}
