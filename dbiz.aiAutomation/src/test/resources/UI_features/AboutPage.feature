Feature: Validating the AboutPage

  Scenario: User navigates to the Dbiz.ai Application Homepage
    Given I browse the Dbiz.ai url
    Then I should be on "Home" page
    And I validate "HomePage" Header Navigation bar elements
    Then I validate "Bannerheading" in homepage
    When I click on "About" link in homepage
    Then I should be on "About" page
    And I validate "About Us" in contactpage