package com.harbour.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmailSubscriptionRepository extends JpaRepository<EmailSubscription, Long> {

    @Query("SELECT email FROM EmailSubscription")
    List<String> getEmails();

    List<EmailSubscription> findEmailSubscriptionByEmail(String email);
}
