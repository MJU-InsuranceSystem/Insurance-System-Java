package org.example.business.education;

import org.example.Team;
import org.example.business.education.model.Education;
import org.example.business.education.model.EducationListImpl;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

/**
 * @author USER
 * @version 1.0
 * @created 21-5-2024 ���� 11:14:31
 */
public class BusinessEducationTeam extends Team {

	public Education m_Education;
	public EducationListImpl m_EducationListImpl;

	public BusinessEducationTeam(){

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
		return null;
	}

	@Override
	public ResponseDto remove(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto retrieve(RequestDto request) {
		return null;
	}


}