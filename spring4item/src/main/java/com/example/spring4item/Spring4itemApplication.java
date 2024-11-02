package com.example.spring4item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring3item.model.Customer;
import com.example.spring4item.repo.CustRepository;
import com.example.spring4item.repo.custRepository;

@SpringBootApplication
public class Spring4itemApplication {

	@Autowired
	private CustRepository custRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring4itemApplication.class, args);
	}

	//起動時に自動的に処理されるメソッド
	@Override
	public void run(String...strings args) throws Exception{
		custRepository.save(new Customer("yamada", "A"));
		custRepository.save(new Customer("tanaka", "B"));
		custRepository.save(new Customer("teshima", "C"));
		custRepository.save(new Customer("uda", "D"));
		custRepository.save(new Customer("touyama", "F"));
		custRepository.save(new Customer("mise", "C"));
	}

}
