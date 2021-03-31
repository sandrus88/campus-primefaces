package org.sg.campus.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ApplicationBean {
	private int num;

	public int getNextInt() {
		return num++;
	}
}
