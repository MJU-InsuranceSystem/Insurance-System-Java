package org.example.business.education;

import java.util.List;
import org.example.Team;
import org.example.business.education.model.Education;
import org.example.business.education.model.EducationListImpl;
import org.example.business.education.view.EducationView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;


public class BusinessEducationTeam extends Team {

	public EducationListImpl educationListImpl;

	public BusinessEducationTeam(EducationListImpl educationListImpl) {
		this.educationListImpl = educationListImpl;
	}

	@Override
	public ResponseDto manage(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto process(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto register(RequestDto request) {
		Education education = new Education();
		education.setName(request.get(EducationView.EDUCATION_NAME));
		education.setContent(request.get(EducationView.EDUCATION_CONTENTS));
		education.setLocation(request.get(EducationView.EDUCATION_LOCATION));
		education.setTextbook(request.get(EducationView.EDUCATION_TEXTBOOK));
		education.setTeacherName(request.get(EducationView.EDUCATION_TEACHER));
		education.setSchedule(request.get(EducationView.EDUCATION_SCHEDULE));
		educationListImpl.add(education);

		ResponseDto responseDto = new ResponseDto();
		responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
		return responseDto;
	}

	@Override
	public ResponseDto remove(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto retrieve(RequestDto request) {
		List<Education> educations = educationListImpl.findAll();
		ResponseDto responseDto = new ResponseDto();
		StringBuilder sb = new StringBuilder();
		for (Education education : educations) {
			sb.append(education.getName()).append("\n");
		}
		responseDto.add(EducationView.ALL_EDUCATION, sb.toString());
		return responseDto;
	}


}