package first.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import first.spring.boot.entity.Customer;
import first.spring.boot.service.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@GetMapping(path = "/getcustomers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<>(this.customerServiceImpl.getAllCustomer(), HttpStatus.OK);
	}

	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
		return new ResponseEntity<>(customerServiceImpl.getCustomerById(id), HttpStatus.OK);
	}

	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer c = this.customerServiceImpl.addCustomer(customer);
		System.out.println(customer);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") int customerId) {
		this.customerServiceImpl.deleteCustomer(customerId);
		return new ResponseEntity<>(HttpStatus.GONE);
	}

	@PutMapping("/updatecustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,
			@PathVariable("customerId") int customerId) {
		this.customerServiceImpl.updateCustomer(customer, customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}

}
