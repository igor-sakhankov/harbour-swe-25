package com.harbour.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailSubscriptionTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmailController emailController;
    @MockBean
    private EmailSubscriptionRepository emailSubscriptionRepository;
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void subscribe() {
	// when
	testRestTemplate.postForEntity("/subscribe/test@test.com", null, Void.class);
	// verify
	EmailSubscription emailSubscription = emailSubscriptionRepository.findAll().stream().findAny().get();
	assertEquals("test@test.com", emailSubscription.getEmail());
    }

    @Test
    void get() {
	// given
//	EmailSubscription emailSubscription = new EmailSubscription();
//	emailSubscription.setId(1L);
//	emailSubscription.setEmail("test@test.com");
//	emailSubscriptionRepository.save(emailSubscription);
	when(emailSubscriptionRepository.findAll()).thenReturn(List.of(new EmailSubscription()));
	// when
	ResponseEntity<List<EmailSubscription>> responseEntity = testRestTemplate.exchange(
		"/emails",
		HttpMethod.GET,
		null,
		new ParameterizedTypeReference<>() {
		}
	);

	List<EmailSubscription> response = responseEntity.getBody();
	// verify

	assertEquals("test@test.com", response.stream().findAny().get().getEmail());
    }

    @Test
    void dataSourceIsH2() {
	System.out.println(dataSource.getClass().getName());

	try (Connection conn = dataSource.getConnection()) {
	    System.out.println(conn.getMetaData().getURL());
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
