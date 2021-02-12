package com.acc.training.policyapigold.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

@Document(collection = "policies-training")
public class Policy {

    @Schema(description = "Id of the customer", example = "POL12345", required = true)
    private String policyId;

    @Schema(description = "Type of policy", example = "Commercial or Personal")
    private String policyType;

    @Schema(description = "Policy effective date", example = "2021/01/09(YYYY/MM/dd)")
    private Date policyEffectiveDate;

    @Schema(description = "Policy end date", example = "2022/01/08(YYYY/MM/dd)")
    private Date policyEndDate;

    @Schema(description = "Customer", example = "{\"customerId\": \"12345\"}")
    private Customer customer;

    

    public String getPolicyId() {
        return this.policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyType() {
        return this.policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Date getPolicyEffectiveDate() {
        return this.policyEffectiveDate;
    }

    public void setPolicyEffectiveDate(Date policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

    public Date getPolicyEndDate() {
        return this.policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}