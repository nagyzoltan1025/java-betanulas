package com.jsf.example;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class ValidateBean {

	private String someValue;

	public String getSomeValue() {
		return someValue;
	}

	public void setSomeValue(String someValue) {
		this.someValue = someValue;
	}
	
	public void checkValue(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(Integer.parseInt((String) value) < -273) {
			String summary = this.getClass().getSimpleName() + ": temp can't be less than -273", detail= summary;
			System.out.println(detail + summary);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
		}
	}
}
