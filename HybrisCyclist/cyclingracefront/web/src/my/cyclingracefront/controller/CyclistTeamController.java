/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package my.cyclingracefront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cyclingrace.cyclistteam.Facade.CyclistTeamFacade;
import my.cyclingraceDaoService.data.CyclistTeamData;


@Controller
public class CyclistTeamController
{
	private CyclistTeamFacade cyclistTeamFacade;



	@RequestMapping(value = "/team")
	public String showTeam(final Model model)
	{
		final List<CyclistTeamData> team = cyclistTeamFacade.getAllCyclistTeam();
		model.addAttribute("team", team);

		return "TeamList";
	}


	@Autowired
	public void setFacade(final CyclistTeamFacade facade)
	{
		this.cyclistTeamFacade = facade;
	}


}


