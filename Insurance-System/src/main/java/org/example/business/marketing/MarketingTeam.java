package org.example.business.marketing;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

/**
 * @author USER
 * @version 1.0
 */
public class MarketingTeam extends Team {

	public Campaign campaign;
	public CampaignListImpl campaignListImpl;

	public MarketingTeam(){

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