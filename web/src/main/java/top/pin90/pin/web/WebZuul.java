package top.pin90.pin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class WebZuul {
    public static void main(String[] args) {
        SpringApplication.run(WebZuul.class,args);
    }
}
