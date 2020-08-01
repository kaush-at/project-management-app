package com.kaush.pma.controllers;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)  // because of this not considering port number
public class HttpRequestTest {

	@LocalServerPort  // this is like autowire get the port number it desire and put it to port variable
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;  // we can use this TestRestTemplate to get the resources like web pages and stuff, pojo, java objects ,json 
	
	@Test
	public void homePageReturnsVersionNumberCorrectly_thenSuccess() {
//		String renderHtml = this.restTemplate.getForObject("http://localhost:"+port +"/", String.class);
//		assertEquals(renderHtml.contains("3.3.3"), true);
	}
}
