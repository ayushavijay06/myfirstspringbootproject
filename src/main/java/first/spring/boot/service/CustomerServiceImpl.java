package first.spring.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import first.spring.boot.entity.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	private static List<Customer> list = new ArrayList<>();

	static {
		list.add(new Customer(1, "ramesh", "udaipur"));
		list.add(new Customer(2, "mahesh", "jaipur"));
		list.add(new Customer(3, "mumkin", "raipur"));
	}

	public List<Customer> getAllCustomer() {
		return list;
	}

	public Customer getCustomerById(int id) {

		Customer customer = null;
		customer = list.stream().filter(e -> e.getCustomerId() == id).findFirst().get();
		return customer;

	}

	public Customer addCustomer(Customer c) {
		list.add(c);
		return c;
	}

	public void deleteCustomer(int customerId) {
		list = list.stream().filter(customer -> customer.getCustomerId() != customerId).collect(Collectors.toList());
	}

	public void updateCustomer(Customer customer, int customerId) {
		list.stream().map(c -> {
			if (c.getCustomerId() == customerId) {
				c.setCustomerName(customer.getCustomerName());
				c.setCustomerCity(customer.getCustomerCity());
			}
			return c;

		}).collect(Collectors.toList());

	}
}
