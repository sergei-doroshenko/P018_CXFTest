package org.sergei.order;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.xml.ws.Endpoint;

/**
 * Created by Sergei_Doroshenko on 4/19/2016.
 */
public class Server {
    /*protected Server() throws Exception {
        System.out.println("Starting Server");
        OrderProcessImpl orderProcessImpl = new OrderProcessImpl();
        String address = "http://localhost:8080/OrderProcess";
        Endpoint.publish(address, orderProcessImpl);
    }
    public static void main(String[] args) throws Exception {
        new Server();
        Thread.sleep(50000);
        System.exit(0);
    }*/

    private Server() {
        OrderProcess orderProcess = new OrderProcessImpl();
        //create WebService service factory
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //register WebService interface
        factory.setServiceClass(OrderProcess.class);
        //publish the interface
        factory.setAddress("http://localhost:9000/OrderProcess");
        factory.setServiceBean(orderProcess);
        //create WebService instance
        factory.create();
    }

    public static void main(String[] args) throws InterruptedException {
        //now start the webservice server
        new Server();
        System.out.println("Server ready...");
        Thread.sleep(1000 * 60);
        System.out.println("Server exit...");
        System.exit(0);
    }
}
