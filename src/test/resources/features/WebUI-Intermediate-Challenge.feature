Feature: WebUI Intermediate Challenge
  Challenge: Create an automated test that reads a message on the admin side of the site.
  You’ll need to trigger a message in the first place, login as admin, open that specific message and validate its contents.

  @wip
  Scenario: User sends an inquiry to the side admin
    Given the user opens up the restful booking platform
    And the user sends a message to the platform admin
    When the site admin opens the platform admin page
    Then the site admin should see the sent message


  Scenario:
    Given given the user clicks the "Let Me Hack " on "Landing Page"