package com.harbour.springboot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailSubscriptionRepository extends CrudRepository<EmailSubscription, Long> {

    @Query("SELECT email FROM EmailSubscription")
    List<String> getEmails();

    List<EmailSubscription> findEmailSubscriptionByEmail(String email);
}
