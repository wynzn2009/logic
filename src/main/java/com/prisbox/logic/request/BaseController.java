/**
 * 
 */
package com.prisbox.logic.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisbox.logic.service.HouseProcessor;
import com.prisbox.logic.service.JobProcessor;

import us.codecraft.webmagic.Spider;

/**
 * @author admin
 *
 */
@Controller
public class BaseController {
	@Autowired
	private MyRequest myRequest;
	@Autowired
	private JobProcessor job;
	@Autowired
	private HouseProcessor house;

	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome() {
		myRequest.someRestCall();
		return "welcome";
	}

	@RequestMapping("/job")
	@ResponseBody
	public String job() {
		job.crawl();
		return "job";
	}

	@RequestMapping("/house")
	@ResponseBody
	public String house() {
		Spider.create(house).addUrl("https://bj.lianjia.com/ershoufang/")
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();
		return "house";
	}
}
