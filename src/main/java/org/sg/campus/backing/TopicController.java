package org.sg.campus.backing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.sg.campus.beans.ApplicationBean;
import org.sg.campus.domain.Course;
import org.sg.campus.domain.Student;
import org.sg.campus.domain.Topic;
import org.sg.campus.util.SGUtil;

@ManagedBean
@SessionScoped
public class TopicController {

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;
	private List<Topic> topicList = new ArrayList<Topic>();
	private List<Topic> searchTopicList = new ArrayList<Topic>();
	private Topic selectedTopic;

	private String newName;
	private String newDescription;

	private String searchName;

	@PostConstruct
	public void init() {
		selectedTopic = new Topic();
		searchTopic();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void addTopic() {
		Topic topic = new Topic();
		topic.setId(applicationBean.getNextInt());
		topic.setName(newName);
		topic.setDescription(newDescription);
		topicList.add(topic);
		System.out.println("Topic " + topic + " added correctly");
		cleanDialogForm();
	}

	public void searchTopic() {
		if (SGUtil.isEmpty(searchName)) {
			searchTopicList = topicList;
			return;
		}
		List<Topic> topicListNew = new ArrayList<>();
		for (Topic topic : topicList) {
			if (!SGUtil.isEmpty(searchName) && topic.getName().toUpperCase().contains(searchName.toUpperCase())) {
				topicListNew.add(topic);
			}
		}
		searchTopicList = topicListNew;
	}

	public void cleanDialogForm() {
		newName = null;
		newDescription = null;
	}

	public void cleanSearchForm() {
		searchName = null;
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
		cleanDialogForm();
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

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}
	
	public List<Topic> getSearchTopicList() {
		return searchTopicList;
	}

	public void setSearchTopicList(List<Topic> searchTopicList) {
		this.searchTopicList = searchTopicList;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String reset() {
		cleanDialogForm();
		return "/app/topic/homeTopic.xhtml?faces-redirect=true";
	}

	public String backHome() {
		cleanDialogForm();
		return "/index.xhtml?faces-redirect=true";
	}
}
