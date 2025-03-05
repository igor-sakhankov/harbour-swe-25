package com.harbour.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    @Autowired
    private ApplicationContext applicationContext;

    private final EmailSubscriptionRepository emailSubscriptionRepository;
    private final StudentRepository studentRepository;

    @PostMapping("/subscribe/{email}")
    public void subscribe(@PathVariable String email) {
	EmailSubscription emailSubscription = new EmailSubscription();
	emailSubscription.setEmail(email);
	emailSubscription.setId(123L);
	emailSubscriptionRepository.save(emailSubscription);
    }

    @GetMapping("emails")
    public Iterable<EmailSubscription> getEmails() {
	Iterable<EmailSubscription> all = emailSubscriptionRepository.findAll();
	for (EmailSubscription emailSubscription : all) {
	    emailSubscription.setEmail(emailSubscription.getEmail().replace("@", " at "));
	}

	if(applicationContext != null) {
	    System.out.println("applicationContext is not null");
	}

	emailSubscriptionRepository.findEmailSubscriptionByEmail("123");
	return all;
    }

    @GetMapping("students")
    public void students() {
	Iterable<Student> all = studentRepository.findAll();
	for (Student student : all) {
	    System.out.println(student.getCourses());
	}
    }
}
