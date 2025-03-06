package com.harbour.springboot;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpStatus;

import static org.springframework.cloud.contract.spec.internal.MediaTypes.APPLICATION_JSON;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class CrudControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testHello() {
	configureWireMock("/crud/hello");
	testRestTemplate.getForEntity("/crud/hello?name=world", String.class);
    }


    private void configureWireMock(String path) {
	WireMock.stubFor(
		WireMock.post(WireMock.urlPathEqualTo(path))
			.willReturn(
				WireMock.aResponse()
					.withStatus(HttpStatus.OK.value())
					.withHeader(CONTENT_TYPE, APPLICATION_JSON)
					.withBody(
						"""
										{
							"message":"success"
										}
										""")));
    }
}
