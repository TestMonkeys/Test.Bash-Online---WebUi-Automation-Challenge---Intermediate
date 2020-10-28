package org.testmonkeys.demo.rbt.test.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testmonkeys.demo.rbt.pageObjects.AdminLoginPage;
import org.testmonkeys.demo.rbt.test.Context;
import org.testmonkeys.demo.rbt.test.actions.ContactActions;
import org.testmonkeys.demo.rbt.test.model.ContactMessage;
import org.testmonkeys.jentitytest.hamcrest.Entity;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.factory.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;


public class AdminBookerSteps {

    @Autowired
    protected Browser browser;
    @Autowired
    protected PageFactory pageFactory;
    @Autowired
    protected ContactActions contactActions;
    @Autowired
    protected Context context;

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
        context.takeScreenshot("Admin Side Message");
    }

}
