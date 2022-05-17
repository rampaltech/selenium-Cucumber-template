Feature:  Selenium test feature
  Background: I setup browser driver

  Scenario: open broswer and invoke url
    Given I open "https://www.nopcommerce.com/en/login?"
    When I enter incorrect username and password
    And hit login
    Then I should see error message