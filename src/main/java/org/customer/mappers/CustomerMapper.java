package org.customer.mappers;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;
import org.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	public CustomerResponseDTO CustomerToDTO(Customer customer);

	public Customer  DTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
