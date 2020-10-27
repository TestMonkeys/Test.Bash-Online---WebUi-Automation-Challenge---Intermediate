package org.testmonkeys.demo.rbt.pageObjects;

import lombok.Getter;
import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.Button;
import org.testmonkeys.maui.pageobjects.elements.Input;

@Getter
@PageAccessor(name = "Admin Login Page", url = "/#/admin")
public class AdminLoginPage extends AbstractPage {

    @ElementAccessor(elementName = "Username", byXPath = "//input[@data-testid='username']")
    private Input username;
    @ElementAccessor(elementName = "Password", byXPath = "//input[@data-testid='password']")
    private Input password;

    @ElementAccessor(elementName = "Login", byXPath = "//button[@data-testid='submit']")
    private Button loginBtn;


}
