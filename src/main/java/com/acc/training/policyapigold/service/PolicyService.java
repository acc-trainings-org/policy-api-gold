package com.acc.training.policyapigold.service;

import java.util.Optional;

import com.acc.training.policyapigold.model.Customer;
import com.acc.training.policyapigold.model.Policy;
import com.acc.training.policyapigold.repository.IPolicyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

@Service
public class PolicyService {

    @Autowired
    IPolicyRepository policyRepository;

    @Autowired
    WebClient customerWebClient;
    
    @Value("${my.path}")
    private String myPath;

    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy getPolicy(String policyId) {
        Policy result = policyRepository.findByPolicyId(policyId);

        if (result == null) {
            return null;
        }

        String customerId = result.getCustomer().getCustomerId();

        Customer customer = customerWebClient.get().uri("/myPath/customer/"+customerId).retrieve().bodyToMono(Customer.class).block();
        if (customer != null){
            result.setCustomer(customer);
        }

        return result;
    }

}
