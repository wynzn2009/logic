/**
 * 
 */
package com.prisbox.logic.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author admin
 *
 */
@TargetUrl("https://bj\\.lianjia\\.com/ershoufang/\\d+\\.html")
@HelpUrl("https://bj\\.lianjia\\.com/ershoufang/pg\\d+")
public class House implements AfterExtractor{
	private String id;
	private String houseType;
	private String unique;
	private String registerTime;
	private String area;
	private int totalPrice;
	private int price;
	private String blockId;
	private String blockName;
	private String title;
	private String longitude;
	private String dimension;
	private String layout;
	private String storey;
	private String architecture;
	private String orientation;
	private String decoration;
	private String household;
	private String heating;
	private String boardingTime;
	private String ownership;
	private String lastTrans;
	private String mortgage;
	
	
	
	
	
	
	
	
	

	@Override
	public void afterProcess(Page page) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
