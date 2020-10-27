package org.testmonkeys.demo.rbt.test.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testmonkeys.demo.rbt.pageObjects.AdminLoginPage;
import org.testmonkeys.demo.rbt.pageObjects.LandingPage;
import org.testmonkeys.demo.rbt.test.Context;
import org.testmonkeys.demo.rbt.test.actions.ContactActions;
import org.testmonkeys.demo.rbt.test.model.ContactMessage;
import org.testmonkeys.jentitytest.hamcrest.Entity;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.factory.PageFactory;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;


public class BasicSteps {

    @Autowired
    protected Browser browser;
    @Autowired
    protected PageFactory pageFactory;
    @Autowired
    protected ContactActions contactActions;
    @Autowired
    protected Context context;

    @Given("the user opens up the restful booking platform")
    public void openBookingPlatform() {
        LandingPage landingPage = pageFactory.createPage(LandingPage.class);
        landingPage.open();

        landingPage.getLetMeHackBtn().click();
    }

    @When("the user sends a message to the platform admin")
    public void sendContactMessage() {
        ContactMessage message = new ContactMessage();
        String uuid = UUID.randomUUID().toString();
        message.setSubject("Subject " + uuid);
        message.setEmail(uuid + "@testmonkeys.org");
        message.setMessage("This is a message with unique identifier: " + uuid);
        message.setName("Name " + uuid);
        String phoneNumber = String.valueOf((long) (Math.random() * (899999999999L)) + (10000000000L));
        message.setPhone(phoneNumber);
        context.put("message", message);
        contactActions.submitContactMessage(message);
    }

    @When("the site admin opens the platform admin page")
    public void adminLogsIn() {
        AdminLoginPage loginPage = pageFactory.createPage(AdminLoginPage.class);
        loginPage.open();
        loginPage.getUsername().type("admin");
        loginPage.getPassword().type("password");
        loginPage.getLoginBtn().click();
    }

    @Then("the site admin should see the sent message")
    public void adminReceivesMessage() {
        ContactMessage expectedMessage = context.get("message");
        ContactMessage actual = contactActions.getMessageFromAdminBySubject(expectedMessage.getSubject());
        assertThat(actual, Entity.isEqualTo(expectedMessage));

    }

}
