package com.mgWork.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private String tkt_id;

	private Long passenger_id;

	private Long customer_id;

	private Long bus_id;

	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	@JsonIgnore
	@UpdateTimestamp
	private Date UpdatedAt;
	@Override
	public String toString() {
		return "Ticket [tkt_id=" + tkt_id + "]";
	}
	
	
	

}





















