package com.home.maxwell.exception;

import java.util.List;

public class ApctlException extends RuntimeException{
	private static final long serialVersionUID = 773283482951098174L;

	protected static String COMMAND_NAME_DEFAULT = "command";

	protected ApctlErrCodeEnum apctlErrCodeEnum;
	protected List<String> paramList;
	protected String commandName = COMMAND_NAME_DEFAULT;
	protected Object command;
	protected String viewName;
	
	public ApctlException(String viewName, ApctlErrCodeEnum errCodeEnum, List<String> paramList, String cmdName, Object cmd){
		this.viewName = viewName;
		this.apctlErrCodeEnum = errCodeEnum;
		this.paramList = paramList;
		this.commandName = cmdName;
		this.command = cmd;
	}
	
	public ApctlErrCodeEnum getApctlErrCodeEnum() {
		return apctlErrCodeEnum;
	}

	public void setApctlErrCodeEnum(ApctlErrCodeEnum apctlErrCodeEnum) {
		this.apctlErrCodeEnum = apctlErrCodeEnum;
	}

	public List<String> getParamList() {
		return paramList;
	}

	public void setParamList(List<String> paramList) {
		this.paramList = paramList;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	
	public Object getCommand() {
		return command;
	}

	public void setCommand(Object command) {
		this.command = command;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
