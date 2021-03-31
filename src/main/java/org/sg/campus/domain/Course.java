package org.sg.campus.domain;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private int id;
	private String name;
	private String description;
	private boolean enabled;
	private List<Topic> topicList = new ArrayList<Topic>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", description: " + description
				+ ", topics: " + topicList + "]";
	}
}
