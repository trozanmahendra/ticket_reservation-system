package com.mgWork.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passenger implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String psngr_name;
	@Column(nullable = false)
	private int psngr_age;
	@Column(nullable = false)
	private Long customerId;

	@Override
	public String toString() {
		return "Passenger [psngr_name=" + psngr_name + ", psngr_age=" + psngr_age + "]";
	}

}
