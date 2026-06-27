Feature: Whitebud Registration
  Background:
    Given Member navigates to the SMAC Web Registration Portal

      Scenario: SMAC Web Registration Portal is displayed
        Then the "SMAC Web Registration" portal is displayed

      Scenario: First Name field is blank
       When the member enters registration details for "fnIsBlank"
       And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
       Then the inline error message "fnIsBlank" is displayed

      Scenario: First Name field is numeric
        When the member enters registration details for "fnIsNumericChar"
        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
        And the member clicks the Proceed button
        Then the inline error message "fnIsNumericChar" is displayed

      Scenario: First Name field is special characters
        When the member enters registration details for "fnIsSpecialChar"
        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
        And the member clicks the Proceed button
        Then the inline error message "fnIsSpecialChar" is displayed

      Scenario: Last Name field is blank
        When the member enters registration details for "lnIsBlank"
        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
        Then the inline error message "lnIsBlank" is displayed

      Scenario: First Name field is numeric
        When the member enters registration details for "lnIsNumericChar"
        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
        And the member clicks the Proceed button
        Then the inline error message "lnIsNumericChar" is displayed

      Scenario: First Name field is special characters
        When the member enters registration details for "lnIsSpecialChar"
        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
        And the member clicks the Proceed button
        Then the inline error message "lnIsSpecialChar" is displayed





#      Scenario Outline: First Name field is numeric
#        When the member enters valid registration details
#        And the member enters "<value>" in the First Name field
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the inline error message "Enter a valid first name." is displayed
#        Examples:
#          |value  |
#          |123    |

#      Scenario: Member should be able to proceed when all required fields are completed correctly
#        When the member enters valid registration details
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the Link Card Page should be displayed










