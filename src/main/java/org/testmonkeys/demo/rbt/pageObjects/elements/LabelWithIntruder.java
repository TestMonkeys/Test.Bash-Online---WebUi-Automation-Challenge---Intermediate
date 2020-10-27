package org.testmonkeys.demo.rbt.pageObjects.elements;


import org.testmonkeys.maui.core.elements.actions.ExecuteJSAction;
import org.testmonkeys.maui.pageobjects.elements.Label;

public class LabelWithIntruder extends Label {

    @Override
    public String getText() {
        return (String) new ExecuteJSAction(this, "return $(arguments[0]).clone().children().remove().end().text()").execute();
    }
}
