package com.example.soap.ws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consume.soap.stub.Acknowledgement;
import com.example.consume.soap.stub.CustomerRequest;
@SpringBootApplication
@RestController
public class SpringBootSoapWsClient1Application {
@Autowired
private SoapClient client;
@PostMapping("/getLoanStatus")
public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
return client.getLoanStatus(request);
}
public static void main(String[] args) {
SpringApplication.run(SpringBootSoapWsClient1Application.class, args);
} }
