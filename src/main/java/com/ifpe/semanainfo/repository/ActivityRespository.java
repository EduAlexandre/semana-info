package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.Activity;

public interface ActivityRespository extends JpaRepository<Activity, Integer> {

	@Query(value =  "select * from activity where time_ini = ?1 AND room = ?2", nativeQuery = true)
	public Activity PickTimeIni(String time,String room);

	@Query(value =  "select * from activity where time_fim = ?1 AND room = ?2", nativeQuery = true)
	public Activity PickTimeFim(String time,String room);

	@Query(value =  "select * from activity where time_fim = ?1 AND speaker = ?2", nativeQuery = true)
	public Activity PickTimeSpeaker( String time,String palestrante);
}
