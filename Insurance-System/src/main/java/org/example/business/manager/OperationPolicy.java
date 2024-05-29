package org.example.business.manager;

import java.util.List;
import org.example.business.education.model.EducationSurvey;

/**
 * @author USER
 * @version 1.0
 */
public class OperationPolicy {

	private String content;
	private int policyId;
	private List<EducationSurvey> educationSurveyPosts;
	public SurveyPost m_surveyPost;

	public OperationPolicy(){

	}

	public void finalize() throws Throwable {

	}

	public List getSurveyPosts(){
		return null;
	}

}