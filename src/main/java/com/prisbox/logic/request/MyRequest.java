/**
 * 
 */
package com.prisbox.logic.request;

import org.apache.log4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author admin
 *
 */
@Service
public class MyRequest {
	private final RestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(MyRequest.class);

    public MyRequest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void someRestCall() {
//    	String url = "https://bj.lianjia.com/ershoufang/pg3/";
    	String url = "https://bj.lianjia.com/ershoufang/101101397011.html/";
    	String result = restTemplate.getForObject(url, String.class);
    	logger.info("---------------------------------------------------------------------------");
    	logger.info(result);
    }
}
