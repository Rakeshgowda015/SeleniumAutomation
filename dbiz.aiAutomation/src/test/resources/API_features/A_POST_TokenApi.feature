Feature: Validating Token API

  Scenario: To validate the Token API
    Given Token Payload
    When user calls TokenAPI with Post http request
    Then the TokenAPI call got success with status code 200
    And Validating response body from the TokenAPI
    When user store token value to Global Constant
