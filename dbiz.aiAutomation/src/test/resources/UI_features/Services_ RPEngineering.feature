Feature: Validating the RapidProductEngineering

  Scenario: User navigates to the Dbiz.ai Application  Rapid Product Engineering
    Given I browse the Dbiz.ai url
    Then I should be on "Home" page
    And I validate "HomePage" Header Navigation bar elements
   Then I validate "Bannerheading" in homepage
    And I click on "RapidProductEngineering" link in homepage
    Then I should be on "RapidProductEngineering" page
  