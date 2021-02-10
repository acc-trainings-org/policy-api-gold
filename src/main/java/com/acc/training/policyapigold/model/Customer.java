package com.acc.training.policyapigold.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Customer {
    
    @Schema(description = "Id of the customer", 
            example = "12345")
	private String customerId;
	
	@Schema(description = "Name of the customer.", 
            example = "Jessica")
	private String customerName;
	
	@Schema(description = "Address of the customer", 
            example = "100 Main Street, 100")
	private String customerAddress;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


}
