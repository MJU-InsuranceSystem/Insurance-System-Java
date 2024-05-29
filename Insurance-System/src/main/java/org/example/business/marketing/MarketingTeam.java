package org.example.business.marketing;

import org.example.Team;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.Response;
import org.example.business.design.view.DesignInspectionController.Function;

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
	public void manage() {

	}

	@Override
	public Response process(Function function, Request request) {
		return null;
	}

	@Override
	public void register() {

	}

	@Override
	public void remove() {

	}

	@Override
	public Object retrieve() {
		return null;
	}

}