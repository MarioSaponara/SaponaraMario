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
package my.cyclingrace.Stage.Service;

import java.util.List;

import my.cyclingraceDaoService.model.StageModel;


/**
 *
 */
public interface StageService
{
	public List<StageModel> getAllStage();

	public List<StageModel> getStageforStageRace(String code);
}
