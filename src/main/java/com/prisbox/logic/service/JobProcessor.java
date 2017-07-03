/**
 * 
 */
package com.prisbox.logic.service;

import org.springframework.stereotype.Service;

import com.prisbox.logic.model.House;
import com.prisbox.logic.pipeline.HouseDaoPipeline;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * @author admin
 *
 */
@Service
public class JobProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(3000);
	
	private HouseDaoPipeline houseDaoPipeline;
	public void crawl() {
        OOSpider.create(site,houseDaoPipeline, House.class)
                .addUrl("https://bj.lianjia.com/ershoufang/pg23")
                .thread(5)
                .run();
    }
	
	
}
