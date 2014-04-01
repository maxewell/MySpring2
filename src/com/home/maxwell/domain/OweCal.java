package com.home.maxwell.domain;

public class OweCal {
	protected OweApp oweApp;
	protected String idn;
	protected String brdate;
	protected String name;
	protected int oweAmount;
	
	public OweApp getOweApp() {
		return oweApp;
	}

	public void setOweApp(OweApp oweApp) {
		this.oweApp = oweApp;
	}

	public String getBrdate() {
		return brdate;
	}

	public void setBrdate(String brdate) {
		this.brdate = brdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOweAmount() {
		return oweAmount;
	}

	public void setOweAmount(int oweAmount) {
		this.oweAmount = oweAmount;
	}

	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
	}
	
	
}
