package com.harbour.selfwrittendi;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class IgorTeacher implements ITeacher {

    @InjectProperty(value = "drink")
    private String favoriteDrink;

    @Override
    public void teach() {
        System.out.println("Teaching... And drinking " + favoriteDrink);
    }
}
