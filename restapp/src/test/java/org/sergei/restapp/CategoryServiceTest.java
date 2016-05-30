package org.sergei.restapp;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Sergei_Doroshenko on 4/27/2016.
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
// D:\Projects\P018_CXFTest\restapp\src\test\resources\applicationContext.xml
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceTest {

    private String basePath = "http://localhost:8080/";

    // I assume that you have in your spring context the rest server
    @Autowired
    private JAXRSServerFactoryBean serverFactory;

    @Autowired
    private CategoryService categoryService;

    private Server server;

    @Before
    public void initialize() throws Exception {
        serverFactory.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
        serverFactory.setServiceBeans(categoryService);
        serverFactory.setAddress(basePath);
        serverFactory.setResourceClasses(CategoryService.class);
        serverFactory.setResourceProvider(CategoryService.class, new SingletonResourceProvider(new CategoryService()));
        serverFactory.setServiceClass(CategoryService.class);
        server = serverFactory.create();
        server.start();
    }

    @Test
    public void getCategoryTest() throws IOException {
        // You can test your rest resources here.
        // Using client factory
        // AutenticationResourceclient = JAXRSClientFactory.create(basePath, AutenticationResource.class);
        // Or URLConnection
//        String query = String.format("invitation=%s", URLEncoder.encode(invitation, "UTF-8"));
        String path = basePath + "/restapp/categoryservice/category/001";
        URL url = new URL( path );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try (InputStream is = connection.getInputStream()) {
            String line;
            // read it with BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @After
    public void afterMethod() {
        server.stop();
    }
}
