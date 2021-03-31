package org.sg.campus.domain;

public class Student {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String jobTitle;
	private PaymentType paymentType;
	private String sex;

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getSex() {
		return sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", surname: " + surname
				+ ", email: " + email + ", job title: " + jobTitle + ", paymentType: " + paymentType + ", sex: " + sex
				+ "]";
	}
}
