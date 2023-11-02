Feature: Validating the ContactPage

  Background: User navigates to the Dbiz.ai Application Homepage
    Given I browse the Dbiz.ai url
    Then I should be on "Home" page
    And I validate "HomePage" Header Navigation bar elements
    Then I validate "Bannerheading" in homepage
    When I click on "Contact" link in homepage
    Then I should be on "Contact" page
    And I validate "Contact US" in contactpage

  Scenario: To validate Contact form submit button functionality in Dbiz.ai Contact Page
  Then submit button should be in "disabled" mode in contactpage
  
  #Scenario: To validate Contact form functionality in Dbiz.ai Contact Page 
    #Then I validate "ContactFormHeader" in contactpage
    #When I enter "Firstname" in contactpage
    #And I enter "Lastname" in contactpage
    #And I enter "Email" in contactpage
    #And I enter "Phonenumber" in contactpage
    #And I enter "Mobilenumber" in contactpage
    #And I enter "Companyname" in contactpage
    #And I enter "Jobtitle" in contactpage
    #And I enter "Industry" in contactpage
    #And I enter "Country/region" in contactpage
    #And I enter "Message" in contactpage
    #And I click on "Mandatorycheckbox" in contactpage
    #And I validate "Mandatorytext" in contactpage
    #And I click on "checkbox" in contactpage
    #When I click on "submit" button in contactpage
    #Then I validate "Successmessage" in contactpage
    #
#
  #Scenario: To validate Contact page  in Dbiz.ai Contact Page 
    #And I validate "Contact us text" in contactpage
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
    
    
    

  
    
    
    
    
    
    
    
