package org.sg.campus.util;

import javax.faces.context.FacesContext;

@SuppressWarnings("unchecked")
public class JsfUtil {
	public static <T> T findBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
}
