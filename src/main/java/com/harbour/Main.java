package com.harbour;


import com.harbour.spring.Capuccino;
import com.harbour.spring.Capuccino2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BarristaConfg.class);
        Capuccino bean = context.getBean("capuccino", Capuccino.class);
        Capuccino2 bean2 = context.getBean("capuccino2", Capuccino2.class);
        bean.getInformation();
        bean2.getInformation();

        new BarristaConfg().skimMilk();
        new Capuccino(null).getInformation();
    }
}