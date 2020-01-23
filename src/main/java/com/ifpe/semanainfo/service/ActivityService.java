package com.ifpe.semanainfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.model.Registrations;
import com.ifpe.semanainfo.repository.ActivityRespository;
import com.ifpe.semanainfo.repository.RegistrationsRepository;
import com.ifpe.semanainfo.util.Functions;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRespository activityRepository;

	@Autowired
	private RegistrationsRepository registrationsRepository;
	
	public void saveActivity(Activity activity) {
		
		String duracao = Functions.duracao(activity.getTimeIni(), activity.getTimeFim());
		activity.setDuracao(duracao);
		
		activityRepository.save(activity);
	}
	
	public List<Activity> listActivity(){
		return activityRepository.findAll();
	}
	
	public Activity get(Integer id) {
		return activityRepository.findById(id).get();
	}
	
	public void deleteActivity(Integer id) {
		this.activityRepository.deleteById(id);
	}

	
	public String registration(Registrations registrations) {
		
		
		Boolean activiCheck = registrationsRepository.pickForIdActivity(registrations.getActivity().getId()) == null;
		
		if(activiCheck == false) {
			return "false";
		}else {
			Boolean regisCheck = registrationsRepository.PickForTimeIni(registrations.getTimeIniActivy()) == null;
			
			if (regisCheck == false) {
				return "existe";
			}else {
				registrationsRepository.save(registrations);
				return "true";
			}
			
		}
		
	}
	
	public void updateAmount(Activity activity,int vaga) {
	
		Activity activityVerifi = activityRepository.findById(activity.getId()).get(); 
		activityVerifi.setAmountVacancies(activityVerifi.getAmountVacancies() - vaga);
		
		activityRepository.save(activityVerifi);

	}
	
	
	//Usuario
	public List<Activity> pickAllForUser(Integer id) {
		return activityRepository.pikActivityForUser(id);
	}

	//PALESTRANTE
	
	
	//VALIDAÇOES
	public Registrations verificaTimeIniUser(String time, Integer id) {

		return registrationsRepository.pickTimeIniUser(time,id);
	}
	
	public Activity verificaTimeIni(String time,String room) {
		return activityRepository.PickTimeIni(time,room);
	}
	
	public Activity verificaTimeFim(String time ,String room) {
		return activityRepository.PickTimeFim(time,room);
	}

	public Activity verificaTimeSpeaker(String time,String palestrante) {
		return activityRepository.PickTimeSpeaker(time,palestrante);
	}

	

	public void deleteRegistration(Integer id) {
		
		Activity activity = activityRepository.findById(id).get();
		activity.setAmountVacancies(activity.getAmountVacancies() + 1);
		
		Registrations registrations= registrationsRepository.pickForIdActivity(id);
		
		registrationsRepository.deleteById(registrations.getId_registration());
		
	}

}
