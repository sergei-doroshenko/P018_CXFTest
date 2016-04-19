package org.sergei.order;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Sergei on 17.04.2016.
 *
 * deploy to tomcat/webapps
 *
 * Endpoint address: http://localhost:8080/orderapp/OrderProcess
 * WSDL : {http://order.sergei.org/}OrderProcessService
 * Target namespace: http://order.sergei.org/
 *
 * get WSDL from http://localhost:8080/orderapp/OrderProcess?wsdl
 *
 */
// endpoint URL - http://localhost:8080/OrderProcess
@WebService(serviceName="OrderProcessService", portName="OrderProcessPort")
public class OrderProcessImpl implements OrderProcess {

    @Override
    @WebMethod(operationName="processOrder")
    public String processOrder(Order order) {
        System.out.println("Processing order...");

        String orderID = validate(order);
        return orderID;
    }

    private String validate(Order order) {
        String custID = order.getCustomerID();
        String itemID = order.getItemID();
        int qty = order.getQty();
        double price = order.getPrice();

        if (custID != null && itemID != null && !custID.equals("") && !itemID.equals("") && qty > 0 && price > 0.0) {
            return "ORD1234";
        }
        return null;
    }
}
