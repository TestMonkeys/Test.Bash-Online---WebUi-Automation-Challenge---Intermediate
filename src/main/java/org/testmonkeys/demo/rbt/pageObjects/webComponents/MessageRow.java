package org.testmonkeys.demo.rbt.pageObjects.webComponents;

import lombok.Getter;
import org.testmonkeys.maui.core.elements.actions.ClickAction;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.elements.Label;
import org.testmonkeys.maui.pageobjects.modules.AbstractModule;

@Getter
public class MessageRow extends AbstractModule {

    @ElementAccessor(elementName = "name", byXPath = ".//div[1]/p")
    private Label fullName;

    @ElementAccessor(elementName = "subject", byXPath = ".//div[2]/p")
    private Label subject;

    public void click() {
        new ClickAction(subject).execute();
    }

}
