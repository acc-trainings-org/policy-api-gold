package com.acc.training.policyapigold.service;

import java.util.Collections;
import java.util.List;

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

    public List<Policy> getPolicies() {
        List<Policy> result = policyRepository.findAll();
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return result;
    }

}
