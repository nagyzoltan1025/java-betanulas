package com.jsf.example;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DateBean {

	private Date date = new Date();

	public DateBean() {

	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
