package com.mgWork.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Bus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bus_id;

	@Column(nullable = false)
	private String bus_name;

	@Column(unique = true, nullable = false)
	private String regId;

	private String bus_type;
	private int seats;
	private String origin;
	private String pickup_point;
	private String destination;
	private String drop_point;
	private float tkt_fare;

	@Future
	private Date start_date;
	@Future
	private Date end_date;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	private Date UpdatedAt;

	@Override
	public String toString() {
		return "Bus [bus_name=" + bus_name + ", regId=" + regId + ", bus_type=" + bus_type + ", seats=" + seats
				+ ", origin=" + origin + ", pickup_point=" + pickup_point + ", destination=" + destination
				+ ", drop_point=" + drop_point + ", tkt_fare=" + tkt_fare + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}

}
