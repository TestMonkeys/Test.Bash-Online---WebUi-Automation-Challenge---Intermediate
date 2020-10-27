package org.testmonkeys.demo.rbt.pageObjects.webComponents;

import lombok.Getter;
import org.testmonkeys.demo.rbt.pageObjects.elements.LabelWithIntruder;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.modules.AbstractModule;
import org.testmonkeys.maui.pageobjects.modules.LazyLoading;

@Getter
public class MessageDetailsModal extends AbstractModule implements LazyLoading {

    @ElementAccessor(elementName = "name", byXPath = ".//div[@class='form-row'][1]/div[1]/p")
    private LabelWithIntruder fullName;
    @ElementAccessor(elementName = "phone", byXPath = ".//div[@class='form-row'][1]/div[2]/p")
    private LabelWithIntruder phone;
    @ElementAccessor(elementName = "email", byXPath = ".//div[@class='form-row'][2]/div[1]/p")
    private LabelWithIntruder email;
    @ElementAccessor(elementName = "subject", byXPath = ".//div[@class='form-row'][3]/div[1]/p/span")
    private LabelWithIntruder subject;
    @ElementAccessor(elementName = "description", byXPath = ".//div[@class='form-row'][4]/div[1]/p")
    private LabelWithIntruder description;

    @Override
    public boolean isReady() {
        //We're assuming all the data loaded up when the subject is not empty
        //the is ready method can't use the elements directly as their initialization depends on isReady()
        String value = this.findElement(subject.getLocator()).getText();
        return !value.isEmpty();
    }
}
