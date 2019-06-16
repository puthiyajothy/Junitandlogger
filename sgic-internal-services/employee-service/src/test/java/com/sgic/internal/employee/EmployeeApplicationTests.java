package com.sgic.internal.employee;


import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class EmployeeApplicationTests {

	@Rule	
	  public WireMockRule wireMockRule = new WireMockRule(options().port(7081).httpsPort(7082));

	  @Autowired
	  protected TestRestTemplate testRestTemplate;
	  protected HttpHeaders httpHeaders = new HttpHeaders();


}
