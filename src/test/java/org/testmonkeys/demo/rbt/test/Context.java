package org.testmonkeys.demo.rbt.test;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

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
}
