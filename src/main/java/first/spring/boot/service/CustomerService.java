package first.spring.boot.service;

import java.util.List;

import first.spring.boot.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer();

	public Customer getCustomerById(int id);

	public Customer addCustomer(Customer c);

	public void deleteCustomer(int customerId);

	public void updateCustomer(Customer customer, int customerId);

}
