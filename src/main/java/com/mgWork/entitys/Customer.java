package com.mgWork.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements Serializable{
		private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique = true)
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(nullable = false)
	@Size(min = 4,message = "Password must be 4 char long")
	private String password;
	
	private int age;
	
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	private Date UpdatedAt;
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email  + ", age=" + age + "]";
	}
	
	

}
