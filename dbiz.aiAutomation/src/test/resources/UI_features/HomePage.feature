Feature: Validating the Homepage

  Background: User navigates to the Dbiz.ai Application Homepage
    Given I browse the Dbiz.ai url
    Then I should be on "Home" page
    And I validate "HomePage" Header Navigation bar elements

  Scenario: To validate Explore Opportunities button functionality in Dbiz.ai Homepage
    When I click on "ExploreOpportunities" button in homepage
    Then I should be on "ExploreOpportunities" page
    
    
  #Scenario: To validate footer Section in Dbiz.ai Homepage
    #And I validate "Get in touch with us" in homepage
    #And I validate "Connect with us" in homepage
    #And I validate "Our Tech Partners" in homepage
#
#
  #Scenario: To validate Dbiz.ai logo functionality in Dbiz.ai Homepage
    #When I click on "Dbiz.ai" logo in homepage
    #Then I validate "Bannerheading" in homepage
    #And I validate "WelcomeText" in homepage
    #And I validate Industries Section in homepage
      #| FINTECH            |
      #| FINANCIAL SERVICES |
      #| CONSTRUCTION       |
      #| HEALTH CARE        |
      #| TELECOMMUNICATION  |
      #| HEALTH TECH        |
      #| AUTOMOTIVE         |
      #| RETAIL             |
    #And I validate Offer Section in homepage
      #| PRODUCT DEVELOPMENT           |
      #| PLATFORM                      |
      #| DATA ARCHITECTURE             |
      #| CLOUD                         |
      #| RAPID APPLICATION DEVELOPMENT |
      #| EXPERIENCE DESIGN             |
      #| DIGITAL MARKETING             |
      #| ACCELERATED GROWTH CONSULTING |
      #| AI                            |
    #And I validate "Offersection" in homepage
    #And I validate "JOIN OUR TEAM" in homepage
    #And I validate "Get in touch with us" in homepage
    #And I validate "Connect with us" in homepage
    #And I validate "Our Tech Partners" in homepage
#
 #
  #Scenario: To validate Contact button functionality in Dbiz.ai Homepage
    #When I click on "Contact" button in homepage
    #Then I should be on "Contact" page
    #And I validate "Contact US" in contactpage
#
#
  #Scenario: To validate Linkedin link functionality in Dbiz.ai Homepage
    #When I click on "Linkedin" link in homepage
    #Then I should be on "(20) DBiz.ai: Overview | LinkedIn" page
#
#
  #Scenario: To validate Twitter link functionality in Dbiz.ai Homepage
    #When I click on "Twitter" link in homepage
    #Then I should be on "Log in to Twitter / X" page
#
 #
  #Scenario: To validate Instagram link functionality in Dbiz.ai Homepage
    #When I click on "Instagram" link in homepage
    #Then I should be on "www.instagram.com" page
#
#
  #Scenario: To validate Facebook link functionality in Dbiz.ai Homepage
    #When I click on "Facebook" link in homepage
    #Then I should be on "DBiz Solutions | Facebook" page
#
  #Scenario: To validate Mail link functionality in Dbiz.ai Homepage
    #When I click on "Mail" link in homepage
