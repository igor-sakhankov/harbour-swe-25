package com.harbour.springboot;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmailControllerTest {

    @Test
    void subscribe() {
        // given
        EmailSubscriptionRepository mock = mock(EmailSubscriptionRepository.class);
        ArgumentCaptor<EmailSubscription> argumentCaptor = ArgumentCaptor.forClass(EmailSubscription.class);
        Clock clock = Clock.fixed(Instant.now(), ZoneId.of("UTC"));

        var emailController = new EmailController(mock, clock);
        // when
        emailController.subscribe("test@mail.com");
        // then
        verify(mock, only()).save(argumentCaptor.capture());
	assertEquals("test@mail.com", argumentCaptor.getValue().getEmail());
	assertEquals(clock.millis(), argumentCaptor.getValue().getId());
    }

    @Test
    void getEmails() {
        // given
        EmailSubscriptionRepository mock = mock(EmailSubscriptionRepository.class);
        EmailSubscription emailSubscription = new EmailSubscription();
        emailSubscription.setEmail("test@mail.com");

        when(mock.findAll()).thenReturn(List.of(emailSubscription));

        var emailController = new EmailController(mock, null);

        // when
        var emails = emailController.getEmails();
        // then
        assertNotNull(emails);
	assertEquals("test@mail.com",emails.stream().findAny().get().getEmail());
    }
}