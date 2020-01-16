package com.ifpe.semanainfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.repository.ActivityRespository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRespository activityRepository;
	
	public void saveActivity(Activity activity) {
		this.activityRepository.save(activity);
	}
	
	public List<Activity> listActivity(){
		return activityRepository.findAll();
	}
	
	public Activity get(Integer id) {
		return activityRepository.findById(id).get();
	}
	
	public void deleteActivity(Activity activity, Integer id) {
		this.activityRepository.deleteById(id);
	}
}
