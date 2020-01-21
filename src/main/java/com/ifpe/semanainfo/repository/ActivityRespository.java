package com.ifpe.semanainfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.Activity;

public interface ActivityRespository extends JpaRepository<Activity, Integer> {

	@Query(value =  "select * from activity where time_ini = ?1 AND room = ?2", nativeQuery = true)
	public Activity PickTimeIni(String time,String room);

	@Query(value =  "select * from activity where time_fim = ?1 AND room = ?2", nativeQuery = true)
	public Activity PickTimeFim(String time,String room);

	@Query(value =  "select * from activity where time_ini = ?1 AND speaker = ?2", nativeQuery = true)
	public Activity PickTimeSpeaker(String time,String palestrante);
	
	@Query(value =  "select * from activity a join registrations r on a.id = r.activity_id where r.user_id = ?1", nativeQuery = true)
	public List<Activity> pikActivityForUser(Integer id);
}

