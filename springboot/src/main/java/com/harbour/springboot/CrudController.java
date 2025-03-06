package com.harbour.springboot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("crud")
@RequiredArgsConstructor
public class CrudController {

    private final EmailSubscriptionRepository emailSubscriptionRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
	if(Objects.equals(name, "world")) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be 'world'");
	}
	return "Hello, " + name + "!";
    }

    @GetMapping("/all")
    PagedModel<EmailSubscription> getSubscriptions(Pageable pageable, @ModelAttribute EmailSubscriptionFilter filter) {
	var all = emailSubscriptionRepository.findAll(filter.toExample(), pageable);
	return new PagedModel<>(all);
    }
}
