package org.testmonkeys.demo.rbt.pageObjects.elements;


import org.testmonkeys.maui.core.elements.actions.ExecuteJSAction;
import org.testmonkeys.maui.pageobjects.elements.Label;

/***
 * Label implementation for html elements that beside text contain other child elements with text, this class will only
 * extract the first level text ignoring child elements.
 */
public class LabelWithIntruder extends Label {

    @Override
    public String getText() {
        return (String) new ExecuteJSAction(this, "return $(arguments[0]).clone().children().remove().end().text()").execute();
    }
}
