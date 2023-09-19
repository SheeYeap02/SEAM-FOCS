package com.seam.focs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ServletComponentScan
public class FocsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FocsApplication.class, args);
        log.info("Run Successfully");
    }
}
