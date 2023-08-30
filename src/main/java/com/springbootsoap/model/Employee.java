package com.springbootsoap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TBL_EMPLOYEE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 177638613061419688L;

	@Id
	@Column(name="EMP_ID")
	private long employeeId;
	
	@Column(name="EMP_NAME")
	private String name;
	
	@Column(name="EMP_DEPARTMENT")
	private String department;
	
	@Column(name="EMP_PHONE")
	private String phone;
	
	@Column(name="EMP_ADDRESS")
	private String address;
}
