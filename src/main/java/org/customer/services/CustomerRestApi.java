package org.customer.services;

import java.util.List;

import org.customer.dto.CustomerResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/users")
public class CustomerRestApi {

	private CustomerServiceImp customerServiceImp;

	public CustomerRestApi(CustomerServiceImp customerServiceImp) {
		this.customerServiceImp = customerServiceImp;
	}

	@GetMapping("/")
	public ResponseEntity<String> getCustomers() {
		List<CustomerResponseDTO> customers = customerServiceImp.getCustomers();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("items", customers);
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	}

	@GetMapping("/{cutomerId}")
	public ResponseEntity<String> getCustomer(@PathVariable String customerId) throws NotFoundException {
		CustomerResponseDTO customer = customerServiceImp.getCustomer(customerId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("item", customer);
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	}

}
