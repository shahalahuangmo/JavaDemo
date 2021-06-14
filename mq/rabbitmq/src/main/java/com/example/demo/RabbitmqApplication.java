package com.example.demo;

import com.example.demo.aop.Landlord;
import com.example.demo.mapper.RabbitmqMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException {

        ApplicationContext context = SpringApplication.run(RabbitmqApplication.class, args);

        Landlord person = context.getBean("landlord", Landlord.class);
        System.out.println(person.toString());



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[]{"0","00","000","0000","00000","000000","0000000"};
        String string;
        while((string = br.readLine()) != null){
            int temp = string.length();
            if(temp == 8){
                System.out.println(string);
            }else if(temp < 8){
                System.out.println(string + strings[8 - temp]);
            }else{
                int number = temp / 8;
                int mod = temp % 8;
                for(int index = 0;index < number; index++){
                    System.out.println(string.substring(index*8,(index+1)*8));
                }
                System.out.println(string.substring(number*8) + strings[8 - mod]);
            }
        }



    }

}
