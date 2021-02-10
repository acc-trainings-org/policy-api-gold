package com.acc.training.policyapigold.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

@Document(collection = "policies-training")
public class Policy {

    @Schema(description = "Id of the customer", 
            example = "POL12345", required = true)
    private String policyId;

    @Schema(description = "Type of policy", 
            example = "Commercial or Personal")
    private String policyType;

    @Schema(description = "Policy effective date", 
            example = "2021/01/09(YYYY/MM/dd)")
    private Date policyEffectiveDate;

    @Schema(description = "Policy end date", 
            example = "2022/01/08(YYYY/MM/dd)")
    private Date policyEndDate;

    @Schema(description = "Customer Details", 
            example = "{\"customerId\": \"12345\", \"customerName\": \"Jessica\", \"customerAddress\": \"100 Main Street, New York\"}")
    private Customer customerDetails;

    public String getPolicyId() {
        return policyId;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public Date getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    public void setPolicyEffectiveDate(Date policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public Customer getCustomerDetails() {
        return this.customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    

}
