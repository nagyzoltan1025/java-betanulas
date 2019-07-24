package com.jsf.example;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class TemperatureValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(Integer.parseInt((String) value) < -273) {
			String summary = this.getClass().getSimpleName() + ": temp can't be less than -273", detail= summary;
			System.out.println(detail);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
		}
	}
}
