package com.harbour.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailSubscriptionRepository emailSubscriptionRepository;

    @PostMapping("/subscribe/{email}")
    public void subscribe(@PathVariable String email) {
	EmailSubscription emailSubscription = new EmailSubscription();
	emailSubscription.setEmail(email);
	emailSubscription.setId(System.currentTimeMillis());
	emailSubscriptionRepository.save(emailSubscription);
    }

    @GetMapping("emails")
    public Iterable<EmailSubscription> getEmails() {
	return emailSubscriptionRepository.findAll();
    }
}
