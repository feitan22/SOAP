package com.example.soap.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.soap.ws.loaneligibility.Acknowledgement;
import com.example.soap.ws.loaneligibility.CustomerRequest;
import com.example.soap.ws.Service.LoanEligibilityService; 

@Endpoint
public class LoanEligibilityIndicatorEndpoint { 

    
    private static final String NAMESPACE = "http://www.example.com/soap/ws/loanEligibility"; 
    
    @Autowired
    private LoanEligibilityService service; 
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        
        return service.checkLoanEligibility(request); 
    }
}