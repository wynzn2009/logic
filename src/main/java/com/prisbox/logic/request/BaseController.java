/**
 * 
 */
package com.prisbox.logic.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 *
 */
@Controller
public class BaseController {
	@Autowired
	private MyRequest myRequest;

	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome() {
		myRequest.someRestCall();
		return "welcome";
	}
}
