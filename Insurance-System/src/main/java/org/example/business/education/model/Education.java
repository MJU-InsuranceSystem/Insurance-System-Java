package org.example.business.education.model;


/**
 * @author USER
 * @version 1.0

 */
public class Education {

	private String content;
	private String location;
	private String name;
	private String schedule;
	private String teacherName;
	private String textbook;

	public String getContent() {
		return content;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getSchedule() {
		return schedule;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getTextbook() {
		return textbook;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setTextbook(String textbook) {
		this.textbook = textbook;
	}
}