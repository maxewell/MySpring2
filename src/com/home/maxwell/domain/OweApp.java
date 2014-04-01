package com.home.maxwell.domain;

import java.util.List;

public class OweApp {
	protected String uno;
	protected String oweYm;
	protected List<OweCal> oweCalList;
	
	public OweApp(){};
	
	public OweApp(String oweYm){
		this.oweYm = oweYm;
	}
	
	public String getUno() {
		return uno;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}
	
	public List<OweCal> getOweCalList() {
		return oweCalList;
	}

	public void setOweCalList(List<OweCal> oweCalList) {
		this.oweCalList = oweCalList;
	}

	public String getOweYm() {
		return oweYm;
	}

	public void setOweYm(String oweYm) {
		this.oweYm = oweYm;
	}
	
	
	
}
