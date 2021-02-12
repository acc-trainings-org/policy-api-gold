package com.acc.training.policyapigold.service;

import com.acc.training.policyapigold.model.Policy;
import com.acc.training.policyapigold.repository.IPolicyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    @Autowired
    IPolicyRepository policyRepository;

    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy getPolicy(String policyId) {
        Policy result = policyRepository.findByPolicyId(policyId);

        //TODO - add web-client to get customer details
        
        if (result == null) {
            return null;
        }
        return result;
    }

}