package com.test4javadev.pashkouski.service;


import com.test4javadev.pashkouski.soap.DateWebService;
import com.test4javadev.pashkouski.soap.SoapDateProducer;

import javax.jws.WebService;


public class SoapService {

    //http://127.0.0.1:8085/dateproducer/soap/DateWebService?wsdl

    public String getDate() {
        SoapDateProducer dateProducer = new SoapDateProducer();
        DateWebService webService = dateProducer.getSoapDateProducerPort();

        return webService.getStringDate();
    }

//    public static void main(String[] args) throws MalformedURLException {
//        SoapDateProducer dateProducer = new SoapDateProducer();
//        DateWebService webService = dateProducer.getSoapDateProducerPort();
//
//        System.out.println(webService.getStringDate());
//    }
}
