package com.acc.training.policyapigold.repository;

import com.acc.training.policyapigold.model.Policy;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPolicyRepository extends MongoRepository<Policy, String> {
    
}
