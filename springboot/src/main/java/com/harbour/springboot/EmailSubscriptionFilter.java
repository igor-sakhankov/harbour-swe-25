package com.harbour.springboot;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.time.LocalDate;

public record EmailSubscriptionFilter(
	String email,
	Boolean active,
	LocalDate createdAfter
) {
    public Example<EmailSubscription> toExample() {
	EmailSubscription probe = new EmailSubscription();

	if (email != null) {
	    probe.setEmail(email);
	}

	ExampleMatcher matcher = ExampleMatcher.matching()
		.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
		.withIgnoreCase();

	return Example.of(probe, matcher);
    }
}
