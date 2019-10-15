package com.designPattens.convertPatten;

public class CustomerConverter extends Converter<CustomerDto, Customer> {

    public CustomerConverter() {
        super(customerDto -> new Customer(customerDto.getCustomerId(), customerDto.getCustomerName(),
                        customerDto.getCustomerLastName(), customerDto.isStatus()),
                customer -> new CustomerDto(customer.getCustomerId(), customer.getCustomerName(),
                        customer.getCustomerLastName(), customer.isStatus()));

    }

}