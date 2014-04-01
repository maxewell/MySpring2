package com.home.maxwell.model.impl;

import com.home.maxwell.domain.OweApp;
import com.home.maxwell.model.OweFacade;

public class OweFacadeImpl implements OweFacade {

	public OweApp getOweApp(String oweYm) {
		return new OweApp(oweYm);
	}

}
