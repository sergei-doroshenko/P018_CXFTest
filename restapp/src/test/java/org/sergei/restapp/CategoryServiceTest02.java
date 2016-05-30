package org.sergei.restapp;

import com.jayway.restassured.response.ValidatableResponse;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.http.ContentType.XML;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Sergei_Doroshenko on 4/27/2016.
 */
//@Ignore
public class CategoryServiceTest02
{
    private Server server;

    @Before
    public void initialize() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses ( CategoryService.class                                                         );
        sf.setResourceProvider( CategoryService.class, new SingletonResourceProvider( new CategoryService() ) );
        sf.setAddress         ( "http://localhost:8080/"                                                      );
        server = sf.create();
        server.start();
    }

    @Test
    public void getCategoryTest() throws IOException
    {
        ValidatableResponse response =
                given().
                    port(8080).
                    pathParam("a", "001").
                when().
//                get("restapp/categoryservice/category/{a}").
                    get("/categoryservice/category/{a}").
                then()
                    .statusCode(200)
//                    .contentType(XML)
                    .and()
                    .body( "Category.categoryId", equalTo("001") )
//                    .and()
                    .body( "Category.categoryName", equalTo("Java") );

        /*response.statusCode(200);
        response.body( "Category.categoryId", equalTo("001") );
        response.body( "Category.categoryName", equalTo("Java") );*/
    }


    @After
    public void afterMethod() {
        server.stop();
    }
}
