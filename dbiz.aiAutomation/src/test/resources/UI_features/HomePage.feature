Feature: Validating the Homepage

  Background: User navigates to the Dbiz.ai Application Homepage
    Given I browse the Dbiz.ai url
    Then I should be on "Home" page
    And I validate "HomePage" Header Navigation bar elements

  @Smoke
  Scenario: To validate Header in Dbiz.ai Homepage
    And I validate "Bannerheading" in homepage
    And I validate "WelcomeText" in homepage

  @Regression @Smoke
  Scenario: To validate Industries Section in Dbiz.ai Homepage
    And I validate Industries Section in homepage
      | FINTECH            |
      | FINANCIAL SERVICES |
      | CONSTRUCTION       |
      | HEALTH CARE        |
      | TELECOMMUNICATION  |
      | HEALTH TECH        |
      | AUTOMOTIVE         |
      | RETAIL             |

  @Smoke
  Scenario: To validate Offer Section in Dbiz.ai Homepage
    And I validate Offer Section in homepage
      | PRODUCT DEVELOPMENT           |
      | PLATFORM                      |
      | DATA ARCHITECTURE             |
      | CLOUD                         |
      | RAPID APPLICATION DEVELOPMENT |
      | EXPERIENCE DESIGN             |
      | DIGITAL MARKETING             |
      | ACCELERATED GROWTH CONSULTING |
      | AI                            |
    And I validate "Offersection" in homepage
    And I validate "JOIN OUR TEAM" in homepage

  @Smoke
  Scenario: To validate footer Section in Dbiz.ai Homepage
    And I validate "Get in touch with us" in homepage
    And I validate "Connect with us" in homepage
    And I validate "Our Tech Partners" in homepage
