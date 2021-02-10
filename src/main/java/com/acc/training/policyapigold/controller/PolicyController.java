package com.acc.training.policyapigold.controller;

import java.util.List;

import com.acc.training.policyapigold.model.Policy;
import com.acc.training.policyapigold.service.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PolicyController {

    @Autowired
    PolicyService policyService;
    
    @Operation(summary = "Create Policy")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "policy created successfully", 
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Policy.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    @RequestMapping(value = "/policy", method = RequestMethod.POST)
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy body) {
        Policy createdPolicy = policyService.createPolicy(body);
        if(null == createdPolicy){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(createdPolicy);

    }
    

    @Operation(summary = "Fetch all policies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the customer", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Policy.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @RequestMapping(value = "/policies", method = RequestMethod.GET)
    public ResponseEntity<List<Policy>> getPolicies() {
        List<Policy> policies = policyService.getPolicies();

        if (policies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(policies);
    }

}
