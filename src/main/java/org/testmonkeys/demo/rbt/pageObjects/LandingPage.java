package org.testmonkeys.demo.rbt.pageObjects;

import lombok.Getter;
import org.testmonkeys.demo.rbt.pageObjects.webComponents.ContactForm;
import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.Button;

@Getter
@PageAccessor(name = "Landing Page", url = "/")
public class LandingPage extends AbstractPage {

    @ElementAccessor(elementName = "Let me hack btn", byXPath = "//div[@id='collapseBanner']//button")
    private Button letMeHackBtn;

    @ElementAccessor(elementName = "Contact Form", byXPath = "//div[@class='row contact']")
    private ContactForm contactForm;

}
