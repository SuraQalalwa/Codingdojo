package com.example.hopperreceipt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HopperReceiptApplication {
	public static void main(String[] args) {
		SpringApplication.run(HopperReceiptApplication.class, args);

		}
		@RequestMapping("/hi")
		public String hi(){
		return "lllll";
		}
	}

