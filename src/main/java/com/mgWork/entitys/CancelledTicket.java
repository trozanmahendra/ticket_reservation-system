package com.mgWork.entitys;

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
import lombok.ToString;
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CancelledTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, updatable = false)
	private String tktId;

	private Long passenger_id;

	private Long customerId;

	
	private Long bus_id;
	@Column(nullable = false)
	private String pickUp;

	@Column(nullable = false)
	private String dropp;

	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	@JsonIgnore
	@UpdateTimestamp
	private Date UpdatedAt;
}
