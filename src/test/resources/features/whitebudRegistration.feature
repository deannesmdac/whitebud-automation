Feature: Whitebud Registration
  Background:
    Given Member navigates to the SMAC Web Registration Portal

      Scenario: SMAC Web Registration Portal is displayed
        Then the "SMAC Registration" portal is displayed

      Scenario: First Name field is required
        When the member leaves the "First Name" field blank
        Then the inline error message "This field is required." should be displayed





