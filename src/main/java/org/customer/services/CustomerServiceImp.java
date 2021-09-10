package org.customer.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;
import org.customer.entities.Customer;
import org.customer.mappers.CustomerMapper;
import org.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;

	public CustomerServiceImp(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerResponseDTO getCustomer(String customerId) throws NotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new NotFoundException("customer with id: " + customerId + " not found "));
		CustomerResponseDTO customerResponseDTO = customerMapper.CustomerToDTO(customer);
		return customerResponseDTO;
	}

	@Override
	public List<CustomerResponseDTO> getCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(item -> customerMapper.CustomerToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerRepository.save(customerMapper.DTOToCustomer(customerRequestDTO));
		return customerMapper.CustomerToDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerRepository.save(customerMapper.DTOToCustomer(customerRequestDTO));
		return customerMapper.CustomerToDTO(customer);
	}

}
