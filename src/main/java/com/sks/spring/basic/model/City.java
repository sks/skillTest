package com.sks.spring.basic.model;

/**
 * @author Sabith_ks
 *
 */
public class City {

	@Override
	public String toString() {
		return "City [cityName=" + cityName + "]";
	}

	/**
	 * 
	 */
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
