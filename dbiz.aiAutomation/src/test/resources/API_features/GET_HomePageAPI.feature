Feature: Validating HomePageAPI

  Scenario: To validate the HomePage API
    Given user calls HomePageAPI with GET http request
    Then the HomePageAPI call got success with status code 200
    And Validating response body from the HomePageAPI