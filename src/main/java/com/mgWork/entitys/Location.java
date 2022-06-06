package com.mgWork.entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = true,nullable = false,unique = true)
	private String location;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<SubLocation> subLocs = new ArrayList<SubLocation>();
	
}
