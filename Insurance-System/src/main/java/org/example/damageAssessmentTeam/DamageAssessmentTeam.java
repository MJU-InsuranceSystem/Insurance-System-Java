package org.example.damageAssessmentTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

/**
 * @author USER
 * @version 1.0
 */
public class DamageAssessmentTeam extends Team {

	public DamageAssessmentTeam(){

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

	public void finalize() throws Throwable {
		super.finalize();
	}


}