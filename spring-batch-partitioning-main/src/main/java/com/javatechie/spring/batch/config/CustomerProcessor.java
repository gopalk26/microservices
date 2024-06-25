//package com.javatechie.spring.batch.config;
//
//import com.javatechie.spring.batch.entity.Customer;
//import org.springframework.batch.item.ItemProcessor;
//
//
//public class CustomerProcessor implements ItemProcessor<Customer,Customer> {
//   @Override
//   public Customer process(Customer customer) throws Exception {
//   	  	           return customer;    }
//}

package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Customer;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	
    public ItemProcessor<Map<String, String>, Customer> processor() {
        return item -> {
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(item.getOrDefault("CUSTOMER_ID", "0")));
            customer.setFirstName(item.getOrDefault("FIRST_NAME", ""));
            customer.setLastName(item.getOrDefault("LAST_NAME", ""));
            customer.setEmail(item.getOrDefault("EMAIL", ""));
            customer.setGender(item.getOrDefault("GENDER", ""));
            customer.setContactNo(item.getOrDefault("CONTACT", ""));
            customer.setCountry(item.getOrDefault("COUNTRY", ""));
            customer.setDob(item.getOrDefault("DOB", ""));
            return customer;
        };
    }

	@Override
	public Customer process(Customer item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
