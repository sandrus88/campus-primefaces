package org.sg.campus.backing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.sg.campus.domain.Course;
import org.sg.campus.domain.Student;
import org.sg.campus.domain.Topic;
import org.sg.campus.util.JsfUtil;

@ManagedBean
@SessionScoped
public class DashboardController {

	private BarChartModel barModel;
	private StudentController student;
	private CourseController course;
	private TopicController topic;
	private List<Student> allStudentsList;
	private List<Course> allCoursesList;
	private List<Topic> allTopicsList;
	
	
	@PostConstruct
	public void init() {
		createBarModel();
		allStudentsList = new ArrayList<>();
		allCoursesList = new ArrayList<>();
		allTopicsList = new ArrayList<>();
	}

	public void createBarModel() {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
		String message;
		getStudentList();
		getCourseList();
		getTopicList();
		barModel = new BarChartModel();
		ChartData data = new ChartData();
		message = bundle.getString("dashboard.title");

		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel(message);

		List<Number> values = new ArrayList<>();
		values.add(allStudentsList.size());
		values.add(allCoursesList.size());
		values.add(allTopicsList.size());
		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		message = bundle.getString("dashboard.students");
		labels.add(message);
		message = bundle.getString("dashboard.courses");
		labels.add(message);
		message = bundle.getString("dashboard.topics");
		labels.add(message);
		data.setLabels(labels);
		barModel.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		linearAxes.setOffset(true);
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel.setOptions(options);
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public List<Student> getStudentList() {
		student = JsfUtil.findBean("studentController");
		allStudentsList = student.getStudentList();
		return allStudentsList;
	}

	public void setStudentList(List<Student> studentList) {
		this.allStudentsList = studentList;
	}

	public List<Course> getCourseList() {
		course = JsfUtil.findBean("courseController");
		allCoursesList = course.getCourseList();
		return allCoursesList;
	}

	public void setCourseList(List<Course> courseList) {
		this.allCoursesList = courseList;
	}

	public List<Topic> getTopicList() {
		topic = JsfUtil.findBean("topicController");
		allTopicsList = topic.getTopicList();
		return allTopicsList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.allTopicsList = topicList;
	}
}
