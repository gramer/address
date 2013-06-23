package com.ligs.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ligs.address.module.MappingColumn;

public class Address {

	@MappingColumn(name="id")
	private String id;

	@MappingColumn(name="name")	
	private String name;

	@MappingColumn(name="email")	
	private String email;

	@MappingColumn(name="cellPhoneNumber")
	private String cellPhoneNumber;

	@MappingColumn(name="birthday")
	private Date birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public Date getBirthday() {
		if (birthday == null)
			return null;
		
		return (Date) this.birthday.clone();
	}

	public String getBirthdayString() {
		if (this.birthday != null) {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(this.birthday);
		}

		return "";

	}

	public void setBirthdayByString(String birthdayString) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		setBirthday(formatter.parse(birthdayString));
	}

	public void setBirthday(Date birthday) {
		this.birthday = (Date) birthday.clone();
	}

}
