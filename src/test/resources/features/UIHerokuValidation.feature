@UIVerifyUserOperations
Feature: HerokuApp API Validation

  @UILoginToDashboard
  Scenario: 
    Given user is on homepage
    When user enters username and logs in
    Then user successfully lands on dashboard page
    And user navigates to multiple challenges
    And user starts multiple challenges and completes it
    And user goes to summary page
    And user total score is displayed in scoreboard
    And user completes challenge successfully
    
    