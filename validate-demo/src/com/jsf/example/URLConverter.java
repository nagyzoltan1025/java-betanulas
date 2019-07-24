package com.jsf.example;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public class URLConverter  implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent c, String val) {
		try {
			return new java.net.URL(val);
		} catch (java.net.MalformedURLException e) {
			FacesMessage msg = new FacesMessage(e.toString());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent c, Object val) {
		return val.toString() + " URLConverter was here";
	}

}
