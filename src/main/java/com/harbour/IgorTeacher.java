package com.harbour;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class IgorTeacher implements ITeacher {
    @Getter
    @Setter
    private String drink;

    @Override
    public void teach() {
        System.out.println("Teaching... And drinking " + drink);
    }
}
