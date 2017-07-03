/**
 * 
 */
package com.prisbox.logic.dao;

import org.apache.ibatis.annotations.Insert;

import com.prisbox.logic.model.House;

/**
 * @author admin
 *
 */
public interface HouseDao {
	@Insert("insert into JobInfo (`title`,`salary`,`company`,`description`,`source`,`url`,`urlMd5`) values (#{title},#{salary},#{company},#{description},#{source},#{url},#{urlMd5})")
    public int add(House houseInfo);
}
