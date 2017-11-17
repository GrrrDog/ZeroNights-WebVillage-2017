package org.greendog.vulns.jdeser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.Base64;
import java.util.Random;

@SpringBootApplication
public class JavaDeserializationApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaDeserializationApplication.class, args);
    }
}
