/**
 * 
 */
package com.prisbox.logic.service;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author admin
 *
 */
public class LoorProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(3000);
	private static final String URL_LIST = "https://bj\\.lianjia\\.com/ershoufang/pg\\d+";
	private static final String URL_POST = "https://bj\\.lianjia\\.com/ershoufang/\\d+\\.html";
	private static final String SCRIPT = "require\\(\\['ershoufang/sellDetail/detailV3'\\].*";

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
//		System.out.println("----------------------------------------------------------------------");
//		System.out.println(page.getUrl().toString());
//		System.out.println("----------------------------------------------------------------------");
//		System.out.println(page.getHtml().toString());
//		System.out.println("----------------------------------------------------------------------");
//		System.out.println(page.getRawText().toString());
//		System.out.println("----------------------------------------------------------------------");
		if(page.getUrl().regex(URL_LIST).match()){
//			page.addTargetRequests(page.getHtml().xpath("//div[@class='sellListContent']").links().regex(URL_POST).all());
			page.addTargetRequests(page.getHtml().xpath("//div[@class='content']//div[@class='leftContent']/ul").links().regex(URL_POST).all());
		}else{
			page.putField("title", page.getHtml().xpath("//div[@class='title']/h1/html()"));
			page.putField("total", page.getHtml().xpath("//div[@class='price']//span[@class='total']/html()"));
			page.putField("communityName", page.getHtml().xpath("//div[@class='communityName']//a[@class='info']/html()"));
			page.putField("unitPrice", page.getHtml().xpath("//div[@class='unitPrice']//span[@class='unitPriceValue']/html()"));
//			page.putField("script", page.getHtml().xpath("//script").regex(SCRIPT));
			String script = page.getHtml().xpath("//script").regex(SCRIPT).toString();
			script = page.getHtml().xpath("//script").regex(SCRIPT).regex("init\\(\\{.*jpg\"\\}\\]").toString()+"}";
			script = script.replaceFirst("init\\(", "");
			JSONObject o = JSON.parseObject(script);
			for(Map.Entry<String, Object> entry : o.entrySet()){
				System.out.println(entry.getKey()+"--------------"+entry.getValue());
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Spider.create(new LoorProcessor())
				.addUrl("https://bj.lianjia.com/ershoufang/pg23")
				// 添加Pipeline
				.addPipeline(new JsonFilePipeline("D:\\webmagic5\\"))
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();
	}
}
