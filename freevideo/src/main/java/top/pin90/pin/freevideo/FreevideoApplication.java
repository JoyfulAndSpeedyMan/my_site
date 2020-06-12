package top.pin90.pin.freevideo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import utils.IdWorker;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
public class FreevideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreevideoApplication.class, args);
    }

    @Bean
    public IdWorker IdWorker() {
        return new IdWorker();
    }

}
