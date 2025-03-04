package com.harbour.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmailUnSubscription {
    @Id
    private Long id;

    private String reasonToUnSubscribe;
}
