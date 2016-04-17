package org.sergei.order;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Sergei on 17.04.2016.
 */
@WebService
public interface OrderProcess {
    @WebMethod
    String processOrder(Order order);
}
