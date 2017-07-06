/**
 * 
 */
package com.prisbox.logic.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.prisbox.logic.dao.HouseDao;
import com.prisbox.logic.model.House;
import com.prisbox.logic.service.util.UserAgentUtil;

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
	private static final String SCRIPT = "require\\(\\['ershoufang/sellDetail/detailV3'\\].*";
	private static final Set<String> idset = new HashSet<String>();
	@Autowired
	private HouseDao dao;

	private Spider spider;

	private boolean flag = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	 */
	@Override
	public Site getSite() {
		return site;
	}

	public static Set<String> getIdset() {
		return idset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.
	 * webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		System.out.println(page.getUrl().toString());
		if (page.getUrl().regex(URL_POST).match()) {
			String url = page.getUrl().toString();
			/*
			 * page.putField("id", url.substring(url.length() - 17, url.length()
			 * - 5)); page.putField("title",
			 * page.getHtml().xpath("//div[@class='title']/h1/html()"));
			 */
			House house = new House();
			house.setId(url.substring(url.length() - 17, url.length() - 5));

			String script = page.getHtml().xpath("//script").regex(SCRIPT).toString();
			script = page.getHtml().xpath("//script").regex(SCRIPT).regex("init\\(\\{.*jpg\"\\}\\]").toString() + "}";
			script = script.replaceFirst("init\\(", "");
			JSONObject o = JSON.parseObject(script);

			house.setTitle(o.getString("title"));
			// house.setTitle(page.getHtml().xpath("//div[@class='title']/h1/html()").toString());
			house.setUrl(url);

			// String temp =
			// page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[4]/html()").toString();
			// int index = temp.indexOf("span>");
			// house.setHouseType(temp.substring(index+5, temp.length()));
			house.setHouseType(o.getString("houseType"));

			house.setUnique(o.getString("isUnique"));

			String temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[1]/html()")
					.toString();
			int index = temp.indexOf("span>");
			house.setRegisterTime(temp.substring(index + 5, temp.length()));
			// temp =
			// page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[3]/html()").toString();
			// index = temp.indexOf("span>");
			// house.setArea(temp.substring(index+5, temp.length()-1));
			house.setArea(o.getString("area"));

			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[5]/html()").toString();
			index = temp.indexOf("span>");
			house.setAreaIn(temp.substring(index + 5, temp.length() - 1));

			house.setTotalPrice(o.getIntValue("totalPrice"));
			// house.setTotalPrice(Integer.valueOf(page.getHtml().xpath("//div[@class='overview']//div[@class='price']//span[@class='total']/html()").toString()));

			// temp =
			// page.getHtml().xpath("//div[@class='overview']//div[@class='unitPrice']//span[@class='unitPriceValue']/html()").toString();
			// index = temp.indexOf("<i>");
			// house.setPrice(Integer.valueOf(temp.substring(0,index)));
			house.setPrice(o.getIntValue("price"));

			house.setBlockId(o.getString("resblockId"));
			house.setBlockName(o.getString("resblockName"));
			// house.setBlockName(page.getHtml().xpath("//div[@class='overview']//div[@class='aroundInfo']//a[@class='info']/html()").toString());

			String[] position = o.getString("resblockPosition").split(",");
			house.setLongitude(position[0]);
			house.setDimension(position[1]);

			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[1]/html()").toString();
			index = temp.indexOf("span>");
			house.setLayout(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[2]/html()").toString();
			index = temp.indexOf("span>");
			house.setStorey(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[6]/html()").toString();
			index = temp.indexOf("span>");
			house.setArchitecture(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[7]/html()").toString();
			index = temp.indexOf("span>");
			house.setOrientation(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[9]/html()").toString();
			index = temp.indexOf("span>");
			house.setDecoration(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[10]/html()").toString();
			index = temp.indexOf("span>");
			house.setHousehold(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='base']//div[@class='content']/ul/li[11]/html()").toString();
			index = temp.indexOf("span>");
			house.setHeating(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[2]/html()")
					.toString();
			index = temp.indexOf("span>");
			house.setOwnership(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[3]/html()")
					.toString();
			index = temp.indexOf("span>");
			house.setLastTrans(temp.substring(index + 5, temp.length()));
			temp = page.getHtml().xpath("//div[@class='transaction']//div[@class='content']/ul/li[7]///span[2]/html()")
					.toString();
			house.setMortgage(temp);

			System.out.println(house);
			if (!idset.contains(house.getId())) {
				dao.add(house);
				idset.add(house.getId());
			}
			if (this.spider != null) {
				spider.getSite().setUserAgent(UserAgentUtil.getUserAgent());
			}

		} else {
			if (flag) {
				idset.addAll(dao.houseidSet());

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
		}
	}

	public void go() {
		Spider s = Spider.create(new HouseProcessor());
		this.spider = s;
		s.addUrl("https://bj.lianjia.com/ershoufang/")
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();
	}

}
