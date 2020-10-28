package org.testmonkeys.demo.rbt.pageObjects.webComponents;

import lombok.Getter;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.elements.Button;
import org.testmonkeys.maui.pageobjects.elements.Input;
import org.testmonkeys.maui.pageobjects.modules.AbstractModule;

@Getter
public class ContactForm extends AbstractModule {

    @ElementAccessor(elementName = "Name", byId = "name")
    private Input fullName;
    @ElementAccessor(elementName = "Email", byId = "email")
    private Input email;
    @ElementAccessor(elementName = "Phone", byId = "phone")
    private Input phone;
    @ElementAccessor(elementName = "Subject", byId = "subject")
    private Input subject;
    @ElementAccessor(elementName = "Text", byId = "description")
    private Input text;

    @ElementAccessor(elementName = "Submit", byId = "submitContact")
    private Button submitBtn;

}
