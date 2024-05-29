package org.example.business.education.model;


import java.util.List;

/**
 * @author USER
 * @version 1.0

 */
public class Education {

	private String content;
	private String location;
	private String name;
	private String schedule;
	private List<EducationSurvey> educationSurveys;
	private List<EducationTarget> educationTargets;
	private String teacherName;
	private String textbook;
	public EducationSurvey m_Education_Survey;
	public EducationTarget m_Education_Target;

	public Education(){

	}

	public void finalize() throws Throwable {

	}

}