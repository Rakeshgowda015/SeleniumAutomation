Feature: Validating AboutPage API

  Scenario: To validate the AboutPage API
    Given user calls AboutPageAPI with GET http request
    Then the AboutPageAPI call got success with status code 200
    And Validating response body from the AboutPageAPI