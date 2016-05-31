package org.sergei.restapp;

import com.jayway.restassured.response.ValidatableResponse;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;


public class CategoryServiceTest02
{
    private static Server server;

    @BeforeClass
    public static void initialize() throws Exception {
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
                    .contentType(JSON)
                    .body( "Category.categoryId", equalTo("001") )
                    .body( "Category.categoryName", equalTo("Java") );

        response.statusCode(200);
        response.body( "Category.categoryId", equalTo("001") );
        response.body( "Category.categoryName", equalTo("Java") );
    }


    @AfterClass
    public static void afterMethod() {
        server.stop();
    }
}
