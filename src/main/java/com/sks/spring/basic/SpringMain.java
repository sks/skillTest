package com.sks.spring.basic;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sks.spring.basic.model.City;

/**
 * @author Sabith_ks
 *
 */
public class SpringMain {

	private static Logger logger	= Logger.getLogger(SpringMain.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = null;
		try{
			context = new ClassPathXmlApplicationContext("spring/springcontext.xml");
			City city	= (City) context.getBean("city");
			logger.info(city);
			
			//Just for a fun , a new thread
			new Thread(() -> {
				//this one is executed out of order 
				logger.info("Threaded instance "+ city);
			}).start();
			//
			//change the beans city name.
			city.setCityName("Somethign NEW");
			
			City city2	= (City) context.getBean("city");
			//prints 'Something New' in singleton scope
			//prints 'Cupertino' in prototype
			logger.info("City 2 "+city2);
			
		}finally{
			if(context!=null){
				context.close();
			}
		}
		
			
	}
}
