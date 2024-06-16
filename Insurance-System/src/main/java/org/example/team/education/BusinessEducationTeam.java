package org.example.team.education;

import java.util.List;
import org.example.team.Team;
import org.example.team.education.model.Education;
import org.example.team.education.model.EducationListImpl;
import org.example.team.education.view.EducationView;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.team.plan.Status;


public class BusinessEducationTeam extends Team {

	public EducationListImpl educationListImpl;

	public BusinessEducationTeam(EducationListImpl educationListImpl) {
		this.educationListImpl = educationListImpl;
	}

	@Override
	public ResponseVO manage(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO process(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO register(RequestVO request) {
		Education education = new Education();
		education.setName(request.get(EducationView.EDUCATION_NAME));
		education.setContent(request.get(EducationView.EDUCATION_CONTENTS));
		education.setLocation(request.get(EducationView.EDUCATION_LOCATION));
		education.setTextbook(request.get(EducationView.EDUCATION_TEXTBOOK));
		education.setTeacherName(request.get(EducationView.EDUCATION_TEACHER));
		education.setSchedule(request.get(EducationView.EDUCATION_SCHEDULE));
		educationListImpl.add(education);

		ResponseVO responseVO = new ResponseVO();
		responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
		return responseVO;
	}

	@Override
	public ResponseVO remove(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO retrieve(RequestVO request) {
		List<Education> educations = educationListImpl.findAll();
		ResponseVO responseVO = new ResponseVO();
		StringBuilder sb = new StringBuilder();
		for (Education education : educations) {
			sb.append(education.getName()).append("\n");
		}
		responseVO.add(EducationView.ALL_EDUCATION, sb.toString());
		return responseVO;
	}


}