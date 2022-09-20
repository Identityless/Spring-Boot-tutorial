package com.example.iocspring;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocspringApplication {

    public static void main(String[] args) {

        SpringApplication.run(IocspringApplication.class, args);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        ApplicationContext context = ApplicationContextProvider.getContext();

        Encoder encoder = context.getBean(Encoder.class);

        String result = encoder.encode(url);

        System.out.println(result);


    }

}
@Configuration
class AppConfig {
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}

