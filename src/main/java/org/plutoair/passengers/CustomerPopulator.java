package org.plutoair.passengers;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerPopulator implements CommandLineRunner {

	@Resource
	private CustomerRepository customerRepo;
	
	
	public void run(String... args) throws Exception {
		
		Customer customerOne = new Customer ("Mark", "Jones");
		customerOne = customerRepo.save(customerOne);
		
		Customer customerTwo = new Customer ("Jack", "Daniels");
		customerTwo = customerRepo.save(customerTwo);
		
	}
	
}
