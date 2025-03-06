package com.harbour.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.util.List;

@Profile("dev,prod")
@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailSubscriptionRepository emailSubscriptionRepository;
    private final Clock clock;

    @PostMapping("/subscribe/{email}")
    public void subscribe(@PathVariable String email) {
	EmailSubscription emailSubscription = new EmailSubscription();
	emailSubscription.setEmail(email);
	emailSubscription.setId(clock.millis());
	emailSubscriptionRepository.save(emailSubscription);
    }

    @GetMapping("emails")
    public List<EmailSubscription> getEmails() {
	List<EmailSubscription> all = emailSubscriptionRepository.findAll();
	return all;
    }
}
