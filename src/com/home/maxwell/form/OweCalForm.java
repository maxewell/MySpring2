package com.home.maxwell.form;

import java.util.ArrayList;
import java.util.List;

import com.home.maxwell.domain.OweApp;
import com.home.maxwell.domain.OweCal;

public class OweCalForm {
	protected String oweYm;
	protected OweApp oweApp;
	protected List<OweCal> oweCalList = new ArrayList<OweCal>();

	public OweCalForm(){
		oweCalList.add(new OweCal());
		oweCalList.add(new OweCal());
	}
	public String getOweYm() {
		return oweYm;
	}
	public void setOweYm(String oweYm) {
		this.oweYm = oweYm;
	}
	public OweApp getOweApp() {
		return oweApp;
	}
	public void setOweApp(OweApp oweApp) {
		this.oweApp = oweApp;
	}
	public List<OweCal> getOweCalList() {
		return oweCalList;
	}
	public void setOweCalList(List<OweCal> oweCalList) {
		this.oweCalList = oweCalList;
	}
	
	public List<OweCal> getList(){
		return this.oweCalList;
	}
	
}
