package org.example.business.marketing;

import org.example.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;

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