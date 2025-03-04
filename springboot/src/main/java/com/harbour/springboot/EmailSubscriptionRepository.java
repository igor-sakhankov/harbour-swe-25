package com.harbour.springboot;

import org.springframework.data.repository.CrudRepository;

public interface EmailSubscriptionRepository extends CrudRepository<EmailSubscription, Long> {
}
