/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package my.cyclingracefront.setup;

import static my.cyclingracefront.constants.CyclingracefrontConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import my.cyclingracefront.constants.CyclingracefrontConstants;
import my.cyclingracefront.service.CyclingracefrontService;


@SystemSetup(extension = CyclingracefrontConstants.EXTENSIONNAME)
public class CyclingracefrontSystemSetup
{
	private final CyclingracefrontService cyclingracefrontService;

	public CyclingracefrontSystemSetup(final CyclingracefrontService cyclingracefrontService)
	{
		this.cyclingracefrontService = cyclingracefrontService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		cyclingracefrontService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CyclingracefrontSystemSetup.class.getResourceAsStream("/cyclingracefront/sap-hybris-platform.png");
	}
}
