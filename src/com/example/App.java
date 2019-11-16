package com.example;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.controller.EmployeeRESTController;

public class App extends Application<Configuration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering REST resources");
        environment.jersey().register(new EmployeeRESTController(environment.getValidator()));
    }

    public static void main(String[] args) throws Exception {
        args = new String[] {"server"};
        new App().run(args);
    }
}
