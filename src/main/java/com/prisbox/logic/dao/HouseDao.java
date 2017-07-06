/**
 * 
 */
package com.prisbox.logic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.prisbox.logic.model.House;

/**
 * @author admin
 *
 */
@Mapper
public interface HouseDao {
	@Insert("insert into house (ID,TITLE,URL,HOUSETYPE,REGISTERTIME,AREA,AREAIN,TOTALPRICE,PRICE,BLOCKID,BLOCKNAME,LAYOUT,STOREY,ARCHITECTURE,ORIENTATION,DECORATION,HOUSEHOLD,HEATING,"
			+ "BOARDINGTIME,OWNERSHIP,LASTTRANS,MORTGAGE,LONGITUDE,DIMENSION,`UNIQUE`) values (#{id},#{title},#{url},#{houseType},#{registerTime},#{area},#{areaIn},#{totalPrice},#{price},#{blockId},#{blockName},#{layout},"
			+ "#{storey},#{architecture},#{orientation},"
			+ "#{decoration},#{household},#{heating},#{boardingTime},#{ownership},#{lastTrans},#{mortgage},#{longitude},#{dimension},#{unique})")
	int add(House houseInfo);

	@Select("select id from house")
	List<String> houseidSet();
}
