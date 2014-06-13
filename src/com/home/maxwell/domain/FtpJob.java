package com.home.maxwell.domain;

public class FtpJob {
	protected String siteName;
	protected String srcFile;
	protected String srcDir;
	protected String destFile;
	protected String destDir;
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSrcFile() {
		return srcFile;
	}
	public void setSrcFile(String srcFile) {
		this.srcFile = srcFile;
	}
	public String getSrcDir() {
		return srcDir;
	}
	public void setSrcDir(String srcDir) {
		this.srcDir = srcDir;
	}
	public String getDestFile() {
		return destFile;
	}
	public void setDestFile(String destFile) {
		this.destFile = destFile;
	}
	public String getDestDir() {
		return destDir;
	}
	public void setDestDir(String destDir) {
		this.destDir = destDir;
	}
	
	
}
