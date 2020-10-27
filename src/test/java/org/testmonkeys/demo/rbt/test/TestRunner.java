package org.testmonkeys.demo.rbt.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        features = "classpath:features/",
        tags = "@wip",
        glue = {//Cucumber Spring configuration & hooks
                "classpath:org.testmonkeys.demo.rbt.test.configuration",
                //Step implementations
                "classpath:org.testmonkeys.demo.rbt.test.stepDefs",
                //Logging utilities for the report
                "classpath:org.testmonkeys.cucumber.spring.logback"
        }

)
public class TestRunner {
}
