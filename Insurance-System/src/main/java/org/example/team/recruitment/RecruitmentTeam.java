package org.example.team.recruitment;

import org.example.team.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;

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
	public ResponseVO manage(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO process(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO register(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO remove(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO retrieve(RequestVO request) {
		return null;
	}
}