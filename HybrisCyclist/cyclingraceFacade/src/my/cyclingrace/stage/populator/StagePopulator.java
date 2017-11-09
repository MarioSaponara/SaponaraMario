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
package my.cyclingrace.stage.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import my.cyclingraceDaoService.data.StageData;
import my.cyclingraceDaoService.data.StageRankingData;
import my.cyclingraceDaoService.model.StageModel;
import my.cyclingraceDaoService.model.StageRankingModel;


/**
 *
 */
public class StagePopulator implements Populator<StageModel, StageData>
{

	AbstractPopulatingConverter<StageRankingModel, StageRankingData> stageRankingConverter;


	/**
	 * @return the stageRankingConverter
	 */
	public AbstractPopulatingConverter<StageRankingModel, StageRankingData> getStageRankingConverter()
	{
		return stageRankingConverter;
	}


	@Required
	public void setStageRankingConverter(
			final AbstractPopulatingConverter<StageRankingModel, StageRankingData> stageRankingConverter)
	{
		this.stageRankingConverter = stageRankingConverter;
	}


	@Override
	public void populate(final StageModel source, final StageData target) throws ConversionException
	{
		target.setCode(source.getCode());
		target.setDays(source.getDays());
		target.setEndDate(source.getEndDate());
		target.setEndPoint(source.getEndPoint());
		target.setStartPoint(source.getStartPoint());
		target.setKm(source.getKm());
		target.setStartdate(source.getStartdate());

		if (!source.getStageRankings().isEmpty())
		{
			final Collection<StageRankingModel> srm = source.getStageRankings();
			final List<StageRankingData> srd = new ArrayList<StageRankingData>();
			for (final StageRankingModel sr : srm)
			{
				srd.add(stageRankingConverter.convert(sr));
			}
			target.setStageRankingsList(srd);
		}


	}

}
