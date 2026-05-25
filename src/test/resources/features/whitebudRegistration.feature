Feature: Whitebud Registration
  Background:
    Given Member access SMAC Web Registration portal

      Scenario: SMAC Web Registration Portal is displayed
        Then the "SMAC Registration" title is displayed
        And the step progress indicator is displayed
        And the registration form fields are displayed
        And the password criteria is displayed
        And the "SMAC updates" checkbox is displayed
        And the "Privacy Policy" checkbox is displayed
        And the "Proceed" button is displayed