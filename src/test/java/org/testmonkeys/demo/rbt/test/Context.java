package org.testmonkeys.demo.rbt.test;

import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testmonkeys.cucumber.spring.logback.CucumberScenarioContext;
import org.testmonkeys.maui.core.browser.Browser;

import java.util.HashMap;

@Component
@ScenarioScope
public class Context {

    private final HashMap<String, Object> dataDictionary;

    public Context() {
        dataDictionary = new HashMap<>();
    }

    public void put(String key, Object object) {
        dataDictionary.put(key, object);
    }

    public <T> T get(String key) {
        return (T) dataDictionary.get(key);
    }

    @Autowired
    private CucumberScenarioContext cukeScenarioContext;

    @Autowired
    private Browser browser;

    public void takeScreenshot(String name) {
        cukeScenarioContext.getCurrentScenario().attach(browser.takeScreenshot(), "image/png", name + ".png");
    }
}
