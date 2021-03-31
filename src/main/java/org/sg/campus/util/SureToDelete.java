package org.sg.campus.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class SureToDelete {
	
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	public ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
	public String message = bundle.getString("student.email.error");
}
