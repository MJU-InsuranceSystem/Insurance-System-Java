package org.example.business.recruitment;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

import java.util.function.Function;

/**
 * @author USER
 * @version 1.0
 *
 */
public class RecruitmentTeam extends Team {

	public Applicant m_Applicant;
	public AppliCantListImpl m_AppliCantListImpl;

	public RecruitmentTeam(){

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