Feature: Validating the ServicesPage

  Scenario: User navigates to the Dbiz.ai Application Homepage
    Given I browse the Dbiz.ai url
    Then I should be on "Home" page
    And I validate "HomePage" Header Navigation bar elements
    Then I validate "Bannerheading" in homepage
    When I click on "Services" link in homepage
    Then I should be on "Services" page
   # And I validate "About Us" in contactpage