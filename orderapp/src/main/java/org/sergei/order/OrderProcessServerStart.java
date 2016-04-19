package org.sergei.order;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sergei_Doroshenko on 4/19/2016.
 */
public class OrderProcessServerStart {
    public static void main(String[] args) {

        // Service instance

        OrderProcess orderProcess = new OrderProcessImpl();
        //AddressVerifyProcess orderProcess = new AddressVerifyProcessImpl();

        JaxWsServerFactoryBean restServer = new JaxWsServerFactoryBean();

        restServer.setServiceBean(orderProcess);

        restServer.setAddress("http://localhost:8080/");

        restServer.create();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            br.readLine();
        } catch (IOException e) {

        }
        System.out.println("Server Stopped");
        System.exit(0);

    }
}
