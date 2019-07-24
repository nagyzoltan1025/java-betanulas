package com.jsf.example;

import java.net.URL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConverterBean {
	private URL beanUrl;

	public URL getBeanUrl() {
		return beanUrl;
	}

	public void setBeanUrl(URL beanUrl) {
		this.beanUrl = beanUrl;
	}

}