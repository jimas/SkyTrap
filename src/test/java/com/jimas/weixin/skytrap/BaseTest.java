package com.jimas.weixin.skytrap;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { 
		"classpath:spring/applicationContext-init.xml",
		"classpath:spring/applicationContext-datasource.xml"
       })
public class BaseTest extends AbstractJUnit4SpringContextTests {

}

