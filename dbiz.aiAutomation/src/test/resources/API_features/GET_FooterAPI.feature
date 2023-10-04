Feature: Validating Footer API

  Scenario: To validate the Footer API
    Given user calls FooterAPI with GET http request
    Then the FooterAPI call got success with status code 200
    And Validating response body from the FooterAPI