package org.sergei.order;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import static javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * Created by Sergei on 17.04.2016.
 */
@WebService
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public interface OrderProcess {

    @WebMethod
    String processOrder(Order order);
}
