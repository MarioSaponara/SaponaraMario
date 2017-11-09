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
package cyclingrace.StageRanking.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.springframework.beans.factory.annotation.Required;

import my.cyclingraceDaoService.data.CyclistData;
import my.cyclingraceDaoService.data.StageRankingData;
import my.cyclingraceDaoService.model.CyclistModel;
import my.cyclingraceDaoService.model.StageRankingModel;


/**
 *
 */
public class StageRankingPopulator implements Populator<StageRankingModel, StageRankingData>
{

	AbstractPopulatingConverter<CyclistModel, CyclistData> cyclistConverter;



	/**
	 * @return the cyclistConverter
	 */
	public AbstractPopulatingConverter<CyclistModel, CyclistData> getCyclistConverter()
	{
		return cyclistConverter;
	}



	@Required
	public void setCyclistConverter(final AbstractPopulatingConverter<CyclistModel, CyclistData> cyclistConverter)
	{
		this.cyclistConverter = cyclistConverter;
	}



	@Override
	public void populate(final StageRankingModel source, final StageRankingData target) throws ConversionException
	{
		target.setCode(source.getCode());
		target.setTimeInSeconds(source.getTimeInSeconds());
		target.setRanking(source.getRanking());
		target.setStatus(source.getStatus().toString());
		if (source.getCyclist() != null)
		{
			target.setCyclist(cyclistConverter.convert(source.getCyclist()));
		}

	}

}
