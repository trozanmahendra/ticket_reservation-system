package com.mgWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgWork.entitys.SubLocation;

public interface SubLocationRepository  extends JpaRepository<SubLocation, Long>{

	SubLocation findBySubLoc(String pickUp);

}
