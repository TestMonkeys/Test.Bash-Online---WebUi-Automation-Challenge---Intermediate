package org.testmonkeys.demo.rbt.test.configuration;

import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.testmonkeys.cucumber.spring.logback.CucumberSpringLoggingConfiguration;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.factory.PageFactory;
import org.testmonkeys.maui.core.factory.PageScanner;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan("org.testmonkeys.demo")
@Import(CucumberSpringLoggingConfiguration.class)
public class CucumberSpringConfiguration {
    @Bean
    @ScenarioScope
    public Browser browser() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        return new Browser(driver, TimeUnit.SECONDS, 10, 20);
    }

    @Bean
    @ScenarioScope
    public PageFactory pageFactory(Browser browser) {
        String testedSite = "http://localhost:8080";
        String site = System.getProperty("site");
        if (site != null && !site.isEmpty())
            testedSite = site;
        return new PageFactory(browser,
                new PageScanner("org.testmonkeys.demo.rbt.pageObjects"),
                testedSite);
    }
}
