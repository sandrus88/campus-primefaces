package org.sg.campus.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.sg.campus.beans.ApplicationBean;
import org.sg.campus.domain.Topic;

@ManagedBean
@SessionScoped
public class TopicController {

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;
	private List<Topic> topicList = new ArrayList<Topic>();
	private Topic selectedTopic;

	private String newName;
	private String newDescription;

	public void addTopic() {
		Topic topic = new Topic();
		topic.setId(applicationBean.getNextInt());
		topic.setName(newName);
		topic.setDescription(newDescription);
		topicList.add(topic);
		System.out.println("Topic " + topic + " added correctly");
		cleanForm();
	}

	public void deleteTopic(Topic topic) {
		topicList.remove(topic);
		System.out.println("Topic " + topic + " deleted correctly");
	}

	public String updateSelectedTopic(Topic topic) {
		selectedTopic = topic;
		return "/app/topic/editTopic.xhtml?faces-redirect=true";
	}

	public String updateTopic() {
		cleanForm();
		System.out.println("Topic " + selectedTopic + " updated correctly");
		return "/app/topic/homeTopic.xhtml?faces-redirect=true";
	}

	public String viewTopic(Topic topic) {
		selectedTopic = topic;
		System.out.println("Topic " + topic + " showed correctly");
		return "/app/topic/viewTopic.xhtml?faces-redirect=true";
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	private void cleanForm() {
		setNewName(null);
		setNewDescription(null);
	}

	public String reset() {
		cleanForm();
		return "/app/topic/homeTopic.xhtml?faces-redirect=true";
	}

	public String backHome() {
		cleanForm();
		return "/index.xhtml?faces-redirect=true";
	}
}
