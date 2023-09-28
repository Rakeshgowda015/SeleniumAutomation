Feature: Validating Token API

  Scenario: Generating the Token
    Given SubmitAPI Payload
    When user calls SubmitAPI with Post http request
    Then the API call got success with status code 200
    And Validating response body from the SubmitAPI
