package com.ifpe.semanainfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Room;
import com.ifpe.semanainfo.repository.RoomDAO;




@Service
public class RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	
	public void saveRoom(Room room) {
		this.roomDAO.save(room);
	}
	
	public List<Room> listRoom(){
		return roomDAO.findAll();
	}
	
	public Room get(Integer id){
		return roomDAO.findById(id).get();
	}
	
	public void deleteRoom(Room room, Integer id) {
		this.roomDAO.deleteById(id);
	}
}
