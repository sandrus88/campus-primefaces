package org.sg.campus.backing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.sg.campus.beans.ApplicationBean;
import org.sg.campus.domain.PaymentType;
import org.sg.campus.domain.Student;

@ManagedBean
@SessionScoped
public class StudentController {

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	private String newName;
	private String newSurname;
	private String newEmail;
	private String newJobTitle;
	private PaymentType newPaymentType;
	private String newSex;

	private List<Student> studentList = new ArrayList<Student>();
	private Student selectedStudent;

	public void addStudent() {
		Student student = new Student();
		student.setId(applicationBean.getNextInt());
		student.setName(newName);
		student.setSurname(newSurname);
		student.setEmail(newEmail);
		student.setJobTitle(newJobTitle);
		student.setPaymentType(newPaymentType);
		student.setSex(newSex);
		studentList.add(student);
		System.out.println("Added student: " + student);
		cleanForm();
	}

	private void cleanForm() {
		setNewName(null);
		setNewSurname(null);
		setNewEmail(null);
		setNewJobTitle(null);
		setNewPaymentType(null);
		setNewSex(null);
	}

	public String reset() {
		cleanForm();
		return "/app/student/homeStudent.xhtml?faces-redirect=true";
	}

	public String backHome() {
		cleanForm();
		return "/index.xhtml?faces-redirect=true";
	}

	public PaymentType[] getEnumValues() {
		PaymentType[] values = PaymentType.values();
		return values;
	}

	public String showPaymentType(PaymentType paymentType) {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
		String label = "";
		if (paymentType != null) {
			label = bundle.getString("student.paymentType." + paymentType);
		}
		return label;
	}

	public String updateSelectedStudent(Student student) {
		selectedStudent = student;
		System.out.println("Going in edit mode for student: " + selectedStudent);
		return "/app/student/editStudent.xhtml?faces-redirect=true";
	}

	public String updateStudent() {
		cleanForm();
		System.out.println("Updated student: " + selectedStudent);
		return "/app/student/homeStudent.xhtml?faces-redirect=true";
	}

	public String viewStudent(Student student) {
		selectedStudent = student;
		System.out.println("View student: " + selectedStudent);
		return "/app/student/viewStudent.xhtml?faces-redirect=true";
	}

	public void deleteStudent(Student student) {
		studentList.remove(student);
		System.out.println("Deleted student: " + selectedStudent.getId());
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setNewSurname(String newSurname) {
		this.newSurname = newSurname;
	}

	public void setNewJobTitle(String newJobTitle) {
		this.newJobTitle = newJobTitle;
	}

	public void setNewSex(String newSex) {
		this.newSex = newSex;
	}

	public String getNewName() {
		return newName;
	}

	public String getNewSurname() {
		return newSurname;
	}

	public String getNewJobTitle() {
		return newJobTitle;
	}

	public String getNewSex() {
		return newSex;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public PaymentType getNewPaymentType() {
		return newPaymentType;
	}

	public void setNewPaymentType(PaymentType newPaymentType) {
		this.newPaymentType = newPaymentType;
	}
}
