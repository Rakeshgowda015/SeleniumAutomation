Feature: Validating ContactPageAPI

  Scenario: To validate the ContactPage API
    Given user calls ContactPageAPI with GET http request
    Then the ContactPageAPI call got success with status code 200
    And Validating response body from the ContactPageAPI