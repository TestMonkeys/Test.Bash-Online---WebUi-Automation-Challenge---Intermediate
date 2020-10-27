package org.testmonkeys.demo.rbt.test.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testmonkeys.demo.rbt.pageObjects.AdminMessagesPage;
import org.testmonkeys.demo.rbt.pageObjects.LandingPage;
import org.testmonkeys.demo.rbt.test.model.ContactMessage;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.factory.PageFactory;

@Component
public class ContactActions {
    @Autowired
    protected Browser browser;
    @Autowired
    protected PageFactory pageFactory;

    public void submitContactMessage(ContactMessage message) {
        LandingPage landingPage = pageFactory.createPage(LandingPage.class);
        landingPage.open();
        landingPage.getContactForm().getFullName().type(message.getName());
        landingPage.getContactForm().getEmail().type(message.getEmail());
        landingPage.getContactForm().getPhone().type(message.getPhone());
        landingPage.getContactForm().getSubject().type(message.getSubject());
        landingPage.getContactForm().getText().type(message.getMessage());
        landingPage.getContactForm().getSubmitBtn().click();
    }

    public ContactMessage getMessageFromAdminBySubject(String subject) {
        AdminMessagesPage messagesPage = pageFactory.createPage(AdminMessagesPage.class);
        messagesPage.open();
        browser.getDynamicWaiter().until(d ->
                messagesPage.getMessageList().getAll()
                        .stream().anyMatch(x -> x.getSubject().getText().equals(subject)));
        messagesPage.getMessageList().getAll().stream().filter(x -> x.getSubject().getText().equals(subject))
                .findFirst().get().click();

        ContactMessage message = new ContactMessage();
        message.setName(messagesPage.getMessageDetails().getFullName().getText());
        message.setPhone(messagesPage.getMessageDetails().getPhone().getText());
        message.setEmail(messagesPage.getMessageDetails().getEmail().getText());
        message.setSubject(messagesPage.getMessageDetails().getSubject().getText());
        message.setMessage(messagesPage.getMessageDetails().getDescription().getText());
        return message;
    }
}
