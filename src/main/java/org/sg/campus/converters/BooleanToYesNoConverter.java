package org.sg.campus.converters;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("booleanToYesNoConverter")
public class BooleanToYesNoConverter implements Converter {

	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	public ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
	public String message;

	public BooleanToYesNoConverter() {
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String param) {
		try {
			Boolean result = Boolean.parseBoolean(param);
			return result;
		} catch (Exception exception) {
			throw new ConverterException(exception);
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
		try {
			if (obj != null && ((Boolean) obj)) {
				message = bundle.getString("course.label.yes");
				return message;
			} else {
				message = bundle.getString("course.label.no");
				return message;
			}
		} catch (Exception exception) {
			throw new ConverterException(exception);
		}
	}
}