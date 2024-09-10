package com.capg.payment_wallet_application.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.dto.CustomerDTO;

public class CustomerUtils {

	private CustomerUtils() {

	}

	public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list) {
		List<CustomerDTO> dtolist = new ArrayList<>();
		for (Customer Customer : list)
			dtolist.add(convertToCustomerDto(Customer));
		return dtolist;
	}

	public static Customer convertToCustomer(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setMobileNo(dto.getMobileNo());
		customer.setName(dto.getName());
		customer.setWallet(WalletUtils.convertToWallet(dto.getWalletDto()));
		return customer;

	}

	public static CustomerDTO convertToCustomerDto(Customer customer) {
		CustomerDTO customerdto = new CustomerDTO();
		customerdto.setMobileNo(customer.getMobileNo());
		customerdto.setName(customer.getName());
		customerdto.setWalletDto(WalletUtils.convertToWalletDto(customer.getWallet()));
		return customerdto;
	}
}
