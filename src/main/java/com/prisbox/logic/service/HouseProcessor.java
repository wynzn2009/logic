/**
 * 
 */
package com.prisbox.logic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisbox.logic.dao.HouseDao;
import com.prisbox.logic.model.House;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author LO
 *
 */
@Service
public class HouseProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(4).setSleepTime(3000);
	private static final String PREFIX = "https://bj.lianjia.com/ershoufang";
	private static final String URL_LIST = "https://bj\\.lianjia\\.com/ershoufang/(pg\\d+/)?";
	private static final String URL_POST = "https://bj\\.lianjia\\.com/ershoufang/\\d+\\.html";
	@Autowired
	private HouseDao dao;

	private boolean flag = true;
	// private static final String SCRIPT =
	// "require\\(\\['ershoufang/sellDetail/detailV3'\\].*";

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	 */
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.
	 * webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		System.out.println(page.getUrl().toString());
		/*if (page.getUrl().regex(URL_LIST).match()) {
			if (flag) {
				List<String> list = new ArrayList<String>(99);
				for (int i = 2; i < 101; i++) {
					list.add(PREFIX + "/pg" + i);
					System.out.println(list.get(i - 2));
				}
				page.addTargetRequests(list);
				flag = false;
			}
			// page.addTargetRequests(page.getHtml().xpath("//div[@class='sellListContent']").links().regex(URL_POST).all());
			List<String> houses = page.getHtml().xpath("//div[@class='content']//div[@class='leftContent']/ul").links()
					.regex(URL_POST).all();
			System.out.println(houses);
			page.addTargetRequests(houses);
		}*/
		if(page.getUrl().regex(URL_POST).match()){
			String url = page.getUrl().toString();
			/*page.putField("id", url.substring(url.length() - 17, url.length() - 5));
			page.putField("title", page.getHtml().xpath("//div[@class='title']/h1/html()"));*/
			House house = new House();
			house.setId(url.substring(url.length() - 17, url.length() - 5));
			house.setTitle(page.getHtml().xpath("//div[@class='title']/h1/html()").toString());
			house.setUrl(url);
			String temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[4]/html()").toString();
			int index = temp.indexOf("span>");
			house.setHouseType(temp.substring(index+5, temp.length()));
			
//			house.setUnique();
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[1]/html()").toString();
			index = temp.indexOf("span>");
			house.setRegisterTime(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[3]/html()").toString();
			index = temp.indexOf("span>");
			house.setArea(temp.substring(index+5, temp.length()-1));
			
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[5]/html()").toString();
			index = temp.indexOf("span>");
			house.setAreaIn(temp.substring(index+5, temp.length()-1));
			
			house.setTotalPrice(Integer.valueOf(page.getHtml().xpath("//div[@class='overview']//div[@class='price']//span[@class='total']/html()").toString()));
			temp = page.getHtml().xpath("//div[@class='overview']//div[@class='unitPrice']//span[@class='unitPriceValue']/html()").toString();
			index = temp.indexOf("<i>");
			house.setPrice(Integer.valueOf(temp.substring(0,index)));
			
//			house.setBlockId();
			house.setBlockName(page.getHtml().xpath("//div[@class='overview']//div[@class='aroundInfo']//a[@class='info']/html()").toString());
			
//			house.setLongitude();
//			house.setDimension();
			
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[1]/html()").toString();
			index = temp.indexOf("span>");
			house.setLayout(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[2]/html()").toString();
			index = temp.indexOf("span>");
			house.setStorey(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[6]/html()").toString();
			index = temp.indexOf("span>");
			house.setArchitecture(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[7]/html()").toString();
			index = temp.indexOf("span>");
			house.setOrientation(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[9]/html()").toString();
			index = temp.indexOf("span>");
			house.setDecoration(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[10]/html()").toString();
			index = temp.indexOf("span>");
			house.setHousehold(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[11]/html()").toString();
			index = temp.indexOf("span>");
			house.setHeating(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[2]/html()").toString();
			index = temp.indexOf("span>");
			house.setOwnership(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[3]/html()").toString();
			index = temp.indexOf("span>");
			house.setLastTrans(temp.substring(index+5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[7]///span[2]/html()").toString();
			house.setMortgage(temp);
			dao.add(house);
			// page.putField("total",
			// page.getHtml().xpath("//div[@class='price']//span[@class='total']/html()"));
			// page.putField("communityName",
			// page.getHtml().xpath("//div[@class='communityName']//a[@class='info']/html()"));
			// page.putField("unitPrice",
			// page.getHtml().xpath("//div[@class='unitPrice']//span[@class='unitPriceValue']/html()"));
			// page.putField("script",
			// page.getHtml().xpath("//script").regex(SCRIPT));
		}else{
			if (flag) {
				List<String> list = new ArrayList<String>(99);
				for (int i = 2; i < /*101*/3; i++) {
					list.add(PREFIX + "/pg" + i);
					System.out.println(list.get(i - 2));
				}
				page.addTargetRequests(list);
				flag = false;
			}
			// page.addTargetRequests(page.getHtml().xpath("//div[@class='sellListContent']").links().regex(URL_POST).all());
			List<String> houses = page.getHtml().xpath("//div[@class='content']//div[@class='leftContent']/ul").links()
					.regex(URL_POST).all();
			System.out.println(houses);
			page.addTargetRequests(houses);
		}
	}

	public void go() {
		Spider.create(new HouseProcessor()).addUrl("https://bj.lianjia.com/ershoufang/")
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();
	}

}
