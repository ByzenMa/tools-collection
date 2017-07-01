package com.nlp.basic.tools.auxiliary;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	/**
	 * @author mabaizhang
	 * @date 2017年6月27日
	 */
	private static final long serialVersionUID = 343073262395477403L;
	private String name;
	private String address;
	private Date dateOfBirth;

	public Student() {
	}

	public Student(String name, String address, Date dateOfBirth) {
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}