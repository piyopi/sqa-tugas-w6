Feature:  log in to the web application

  Scenario : user can login with valid credential
    Given user launch the web app
    When user input a registered user
    And user input a registered password
    And user tap login button
    Then user can log in and redirected to Dashboard Page


