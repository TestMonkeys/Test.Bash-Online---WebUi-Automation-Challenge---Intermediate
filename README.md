# Test.Bash-Online---WebUi-Automation-Challenge---Intermediate
This repo shows the solution to the Test.bash('Online') AutomationWeek WebUI intermediate challenge:
```
Create an automated test that reads a message on the admin side of the site.

You’ll need to trigger a message in the first place, login as admin, open that specific message and validate its contents.
```
The challenge is based on the [Restfull Booking Platform](https://github.com/TestMonkeys/restful-booker-platform) 

It uses TestMonkeys [maui framework](https://github.com/TestMonkeys/maui) for web automation and [jEntityTest](https://github.com/TestMonkeys/jEntityTest) for objects comparison.

## Check it out
1. Clone the [Restfull Booking Platform](https://github.com/TestMonkeys/restful-booker-platform) and follow the instructions from its readme to start the restful booker platform locally
2. Clone this repo
3. run `mvn test` to run the test
   
   *Note:* to specify an external url for the restful booker platform add the site parameter, ex: `mvn test -Dsite="https://aw1.automationintesting.online"`
4. run ```mvn cucumber-reporting:generate``` to generate the cucumber html report at `target/report/cucumber-html-reports`
