/**
 * 
 */
package com.prisbox.logic.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author admin
 *
 */
@TargetUrl("https://bj.lianjia.com/ershoufang/\\d+.html")
@HelpUrl("/ershoufang/pg\\d+")
public class House implements AfterExtractor {
	@ExtractByUrl
	private String url;
	private String id;
	private String houseType;
	private String unique;
	private String registerTime;
	private String area;
	private String areaIn;
	private int totalPrice;
	private int price;
	private String blockId;
	private String blockName;
	@ExtractBy("//div[@class='title']/h1/html()")
	private String title;
	private String longitude;
	private String dimension;
	private String layout;
	private String storey;
	private String architecture;
	private String orientation;
	private String decoration;
	private String household;
	private String heating;
	private String boardingTime;
	private String ownership;
	private String lastTrans;
	private String mortgage;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "House [url=" + url + ", id=" + id + ", houseType=" + houseType + ", unique=" + unique
				+ ", registerTime=" + registerTime + ", area=" + area + ", areaIn=" + areaIn + ", totalPrice="
				+ totalPrice + ", price=" + price + ", blockId=" + blockId + ", blockName=" + blockName + ", title="
				+ title + ", longitude=" + longitude + ", dimension=" + dimension + ", layout=" + layout + ", storey="
				+ storey + ", architecture=" + architecture + ", orientation=" + orientation + ", decoration="
				+ decoration + ", household=" + household + ", heating=" + heating + ", boardingTime=" + boardingTime
				+ ", ownership=" + ownership + ", lastTrans=" + lastTrans + ", mortgage=" + mortgage + "]";
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the areaIn
	 */
	public String getAreaIn() {
		return areaIn;
	}

	/**
	 * @param areaIn the areaIn to set
	 */
	public void setAreaIn(String areaIn) {
		this.areaIn = areaIn;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
		
		this.id = url.substring(url.length()-17, url.length()-5);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the houseType
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * @param houseType
	 *            the houseType to set
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	/**
	 * @return the unique
	 */
	public String getUnique() {
		return unique;
	}

	/**
	 * @param unique
	 *            the unique to set
	 */
	public void setUnique(String unique) {
		this.unique = unique;
	}

	/**
	 * @return the registerTime
	 */
	public String getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime
	 *            the registerTime to set
	 */
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the blockId
	 */
	public String getBlockId() {
		return blockId;
	}

	/**
	 * @param blockId
	 *            the blockId to set
	 */
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	/**
	 * @return the blockName
	 */
	public String getBlockName() {
		return blockName;
	}

	/**
	 * @param blockName
	 *            the blockName to set
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the layout
	 */
	public String getLayout() {
		return layout;
	}

	/**
	 * @param layout
	 *            the layout to set
	 */
	public void setLayout(String layout) {
		this.layout = layout;
	}

	/**
	 * @return the storey
	 */
	public String getStorey() {
		return storey;
	}

	/**
	 * @param storey
	 *            the storey to set
	 */
	public void setStorey(String storey) {
		this.storey = storey;
	}

	/**
	 * @return the architecture
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * @param architecture
	 *            the architecture to set
	 */
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	/**
	 * @return the orientation
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation
	 *            the orientation to set
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return the decoration
	 */
	public String getDecoration() {
		return decoration;
	}

	/**
	 * @param decoration
	 *            the decoration to set
	 */
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	/**
	 * @return the household
	 */
	public String getHousehold() {
		return household;
	}

	/**
	 * @param household
	 *            the household to set
	 */
	public void setHousehold(String household) {
		this.household = household;
	}

	/**
	 * @return the heating
	 */
	public String getHeating() {
		return heating;
	}

	/**
	 * @param heating
	 *            the heating to set
	 */
	public void setHeating(String heating) {
		this.heating = heating;
	}

	/**
	 * @return the boardingTime
	 */
	public String getBoardingTime() {
		return boardingTime;
	}

	/**
	 * @param boardingTime
	 *            the boardingTime to set
	 */
	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	/**
	 * @return the ownership
	 */
	public String getOwnership() {
		return ownership;
	}

	/**
	 * @param ownership
	 *            the ownership to set
	 */
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	/**
	 * @return the lastTrans
	 */
	public String getLastTrans() {
		return lastTrans;
	}

	/**
	 * @param lastTrans
	 *            the lastTrans to set
	 */
	public void setLastTrans(String lastTrans) {
		this.lastTrans = lastTrans;
	}

	/**
	 * @return the mortgage
	 */
	public String getMortgage() {
		return mortgage;
	}

	/**
	 * @param mortgage
	 *            the mortgage to set
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	@Override
	public void afterProcess(Page page) {
		// TODO Auto-generated method stub

	}

	public void setTotalPrice(Integer valueOf) {
		// TODO Auto-generated method stub
		this.totalPrice = valueOf;
	}

}
