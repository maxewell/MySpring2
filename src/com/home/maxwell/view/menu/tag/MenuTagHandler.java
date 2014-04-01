package com.home.maxwell.view.menu.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuTagHandler extends TagSupport{
	String menustr = "<div id=\"menu\">	<ul>		<li class=\"top\"><a href=\"#\"><img src=\"images/icon_office_disk.gif\" /><span class=\"downarrow\">PC</span></a>			<ul class=\"first\">				<li><a href=\"http://www.google.com.tw\"><img src=\"images/icon_office_disk.gif\" /><span>HP</span></a></li>				<li class=\"sub\"><a href=\"#\"><img src=\"images/icon_office_disk.gif\" /><span class=\"rightarrow\">IBM</span></a>					<ul>						<li class=\"sub\"><a href=\"#\"><img src=\"images/icon_office_abc.gif\" /><span class=\"rightarrow\">T Series</span></a>							<ul>								<li><a href=\"http://www.google.com.tw\"><img src=\"images/icon_office_a.gif\" /><span>T420S</span></a></li>								<li><a href=\"#\"><img src=\"images/icon_office_a.gif\" /><span>T430S</span></a></li>							</ul>						</li>						<li><a href=\"#\" href=\"http://www.google.com.tw\"><img src=\"images/icon_office_abc.gif\" /><span>S Serise</span></a></li>									</ul>				</li>			</ul>		</li>		<li class=\"top\"><a href=\"#\"><img src=\"images/icon_office_marks.gif\"/><span class=\"downarrow\">Phone</span></a>			<ul class=\"first\">				<li><a href=\"#\"><img src=\"images/icon_office_light.gif\"/><span>Apple</span></a></li>				<li class=\"sub\"><a href=\"#\"><img src=\"images/icon_office_light.gif\" /><span class=\"rightarrow\">Google</span></a>					<ul>						<li><a href=\"#\"><img src=\"images/icon_office_list.gif\" /><span>HTC</span></a></li>						<li class=\"sub\"><a href=\"#\"><img src=\"images/icon_office_list.gif\" /><span class=\"rightarrow\">LG</span></a>							<ul>								<li><a href=\"#\"><img src=\"images/icon_office_list.gif\" /><span>G2</span></a></li>								<li><a href=\"#\"><img src=\"images/icon_office_list.gif\" /><span>G Pro</span></a></li>							</ul>						</li>						<li><a href=\"#\"><img src=\"images/icon_office_list.gif\" /><span>SONY</span></a></li>					</ul>				</li>			</ul>		</li>	</ul></div>";
	@Override
    public int doStartTag() throws JspException {
    	try{
    		JspWriter out = pageContext.getOut();
    		out.println("This is menu");
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    	return SKIP_BODY;
    }
}
