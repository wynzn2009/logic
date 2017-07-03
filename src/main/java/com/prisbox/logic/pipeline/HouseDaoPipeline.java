/**
 * 
 */
package com.prisbox.logic.pipeline;

import org.springframework.beans.factory.annotation.Autowired;

import com.prisbox.logic.dao.HouseDao;
import com.prisbox.logic.model.House;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * @author admin
 *
 */
public class HouseDaoPipeline implements PageModelPipeline<House>{
	@Autowired
    private HouseDao houseDao;
	@Override
	public void process(House t, Task task) {
		// TODO Auto-generated method stub
		
	}

}
