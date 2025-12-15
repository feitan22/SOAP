package com.example.soap.ws.Config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWSConfig {

    // 1. Configuration du MessageDispatcherServlet
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // 2. Génération du WSDL à l'URL /ws/loanEligibility.wsdl
    @Bean(name = "loanEligibility")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("LoanEligibilityPort"); // Nom standard pour le port
        defaultWsdl11Definition.setLocationUri("/ws");
        
        
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soap/ws/loanEligibility");
        
        defaultWsdl11Definition.setSchema(schema);
        return defaultWsdl11Definition;
    }

    // 3. Chargement du Schéma XSD
    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
    }
} 