/**
 * 
 */
package com.prisbox.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisbox.logic.model.House;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * @author admin
 *
 */
@Service
public class JobProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(3000);
	@Autowired
	private PageModelPipeline<House> houseDaoPipeline;
	public void crawl() {
        OOSpider.create(site,houseDaoPipeline, House.class)
                .addUrl("https://bj.lianjia.com/ershoufang/pg23")
                .thread(1)
                .run();
    }
	
}
