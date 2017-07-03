/**
 * 
 */
package com.prisbox.logic.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.prisbox.logic.model.House;

/**
 * @author admin
 *
 */
@Mapper
public interface HouseDao {
	@Insert("insert into house (ID,TITLE,URL,HOUSETYPE,REGISTERTIME,AREA,AREAIN,TOTALPRICE,PRICE,BLOCKNAME,LAYOUT,STOREY,ARCHITECTURE,ORIENTATION,DECORATION,HOUSEHOLD,HEATING,"
			+ "BOARDINGTIME,OWNERSHIP,LASTTRANS,MORTGAGE) values (#{id},#{title},#{url},#{houseType},#{registerTime},#{area},#{areaIn},#{totalPrice},#{price},#{blockName},#{layout},"
			+ "#{storey},#{architecture},#{orientation},"
			+ "#{decoration},#{household},#{heating},#{boardingTime},#{ownership},#{lastTrans},#{mortgage})")
	int add(House houseInfo);
}
