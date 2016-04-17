package org.sergei.order.client;

import org.sergei.order.Order;
import org.sergei.order.OrderProcess;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergei on 17.04.2016.
 */
public class Client {
    public static final String PATH
            = "file:D:\\IdeaProjects\\P018_CXFTest\\orderapp\\src\\main\\java\\org\\sergei\\order\\client\\client-beans.xml";

    public Client() {
    }

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(PATH);

        OrderProcess client = (OrderProcess) context.getBean("orderClient");
        Order order = new Order();
        order.setCustomerID("C001");
        order.setItemID("I001");
        order.setQty(100);
        order.setPrice(200.00);

        String orderID = client.processOrder(order);
        String message = (orderID == null) ? "Order not approved" : "Order approved; order ID is " + orderID;
        System.out.println(message);

    }
}
