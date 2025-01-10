package jpabook.jpashoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashoopApplication {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.setData("hi");
		String data = hello.getData();
		System.out.println(data);
		SpringApplication.run(JpashoopApplication.class, args);
	}

}
