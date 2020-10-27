package org.testmonkeys.demo.rbt.test.configuration;

import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.factory.PageFactory;

@CucumberContextConfiguration
@ContextConfiguration(classes = CucumberSpringConfiguration.class)
public class Hooks {
    @Autowired
    protected Browser browser;
    @Autowired
    protected PageFactory pageFactory;

    @After
    public void cleanup() {
        browser.quit();
    }
}
