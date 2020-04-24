package com.application;

import com.application.bean.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ServletComponentScan
@ImportResource("classpath:app-config.xml")
public class SpringBootStarter {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootStarter.class);

        Car ladaKalina = (Car)context.getBean("ladaKalina");
        Car kiaRio = (Car)context.getBean("kiaRio");
        Car cayene = (Car)context.getBean("cayene");
        Car macan = (Car)context.getBean("macan");
        Car niva = (Car)context.getBean("niva");

        System.out.println("cayene= " + cayene);
        System.out.println("ladaKalina= " + ladaKalina);
        System.out.println("kiaRio= " + kiaRio);
        System.out.println("macan= " + macan);
        System.out.println("niva= " + niva);
    }
}
