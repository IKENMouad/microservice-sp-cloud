package org.customer.services;

import java.util.List;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;

public interface CustomerService {

	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);

	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);

	CustomerResponseDTO getCustomer(String customerId) throws Exception;

	List<CustomerResponseDTO> getCustomers();

}
