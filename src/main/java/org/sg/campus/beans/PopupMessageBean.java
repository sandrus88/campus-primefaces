package org.sg.campus.beans;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

@ManagedBean
@ViewScoped
public class PopupMessageBean {
	
	private Locale locale;
	private ResourceBundle bundle;
	private String message;
	
	public void showMessage() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		bundle = ResourceBundle.getBundle("messages.messages", locale);
		message = bundle.getString("popup.message.delete");
		FacesMessage msg = new FacesMessage(message);
		PrimeFaces.current().dialog().showMessageDynamic(msg);
		
	}

}
