package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.semanainfo.model.Room;


public interface RoomDAO extends JpaRepository<Room, Integer> {


}
