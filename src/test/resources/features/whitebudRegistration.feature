Feature: Whitebud Registration
  Background:
    Given Member navigates to the SMAC Web Registration Portal

      Scenario: SMAC Web Registration Portal is displayed
        Then the "SMAC Web Registration" portal is displayed

      Scenario: First Name field is blank
       When the member enters registration details for "fnIsBlank"
       Then the inline error message "fnIsBlank" is displayed

      Scenario: First Name field is numeric
        When the member enters registration details for "fnIsNumericChar"
        And the member scrolls to the "proceedButtonDP"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        Then the inline error message "fnIsNumericChar" is displayed

      Scenario: First Name field is special characters
        When the member enters registration details for "fnIsSpecialChar"
        And the member scrolls to the "proceedButtonDP"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        Then the inline error message "fnIsSpecialChar" is displayed

      Scenario: First Name field is alpha characters
        When the member enters registration details for "fnIsValid"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        And the member scrolls to the "firstNameField"
        Then no inline error message is displayed for "fnIsValid"

      Scenario: Last Name field is blank
        When the member enters registration details for "lnIsBlank"
        Then the inline error message "lnIsBlank" is displayed

      Scenario: Last Name field is numeric
        When the member enters registration details for "lnIsNumericChar"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        Then the inline error message "lnIsNumericChar" is displayed

      Scenario: Last Name field is special characters
        When the member enters registration details for "lnIsSpecialChar"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        Then the inline error message "lnIsSpecialChar" is displayed

#      Scenario: Last Name field is alpha characters
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the inline error message "" is displayed

      Scenario: Mobile Number field is blank
        When the member enters registration details for "mobIsBlank"
        Then the inline error message "mobIsBlank" is displayed

      Scenario: Mobile Number field is alpha characters
        When the member enters registration details for "mobIsAlphaChar"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        Then the inline error message "mobIsAlphaChar" is displayed

      Scenario: Mobile Number field is special characters
        When the member enters registration details for "mobIsSpecialChar"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        Then the inline error message "mobIsSpecialChar" is displayed

#      Scenario: Mobile Number field is numeric characters
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        Then the inline error message "" is displayed

      Scenario: Mobile Number field is less than 10 numeric characters
        When the member enters registration details for "mobIsIncomplete"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        Then the inline error message "mobIsIncomplete" is displayed

      Scenario: Mobile Number is in invalid format
        When the member enters registration details for "mobIsInvalidFormat"
        Then the inline error message "mobIsInvalidFormat" is displayed

      Scenario: Mobile Number already exist
        When the member enters registration details for "mobIsAlreadyExist"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        Then the inline error message "mobIsAlreadyExist" is displayed

#      Scenario: Mobile Number is in valid format
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the inline error message "" is displayed

#      Scenario: Email Address field is blank
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        Then the inline error message "" is displayed

#      Scenario: Email Address field is alpha characters
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        Then the inline error message "" is displayed

#      Scenario: Email Address field is numeric characters
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        Then the inline error message "" is displayed

#      Scenario: Email Address field is invalid special characters
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        Then the inline error message "" is displayed

      Scenario: Email Address has invalid format
        When the member enters registration details for "emailIsInvalidFormat"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        And the member clicks the "proceedButtonDP"
        Then the inline error message "emailIsInvalidFormat" is displayed

#      Scenario: Email Address already exist
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the inline error message "" is displayed

#      Scenario: Email Address is valid
#        When the member enters registration details for ""
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the inline error message "" is displayed

      Scenario: Birthday field is blank
        When the member enters registration details for "dobIsBlank"
        Then the inline error message "dobIsBlank" is displayed

      Scenario: Birthday field is alpha characters
        When the member enters registration details for "dobIsAlphaChar"
        Then the inline error message "dobIsAlphaChar" is displayed

      Scenario: Birthday field is special characters
        When the member enters registration details for "dobIsSpecialChar"
        Then the inline error message "dobIsSpecialChar" is displayed

#      Scenario: Birthday field is numeric characters
#        When the member enters registration details for ""
#        Then the inline error message "" is displayed

      Scenario: Birthday field is invalid format
        When the member enters registration details for "dobIsInvalidFormat"
        Then the inline error message "dobIsInvalidFormat" is displayed

      Scenario: Birthday field is below 18 years old
        When the member enters registration details for "dobIsBelowReq"
        Then the inline error message "dobIsBelowReq" is displayed

#      Scenario: Birthday field is valid
#        When the member enters registration details for ""
#        Then the inline error message "" is displayed

#      Scenario: Birthday field calendar picker is working
#        When the member enters registration details for ""
#        Then the inline error message "" is displayed

      Scenario: Password field is blank
        When the member enters registration details for "pwIsBlank"
        Then the inline error message "pwIsBlank" is displayed

      Scenario: Confirm Password field is blank
        When the member enters registration details for "cpwIsBlank"
        And the member ticks the SMAC Terms&Conditions and Data Privacy Policy
        Then the proceed button is "clickable"

      Scenario: Password field is minimum characters
        When the member enters registration details for "pwIsMinChar"
        And the inline error message "pwIsMinChar" is displayed
        Then the "Minimum 8 Characters" password criteria is enabled

      Scenario: Password field has upper and lower case
        When the member enters registration details for "pwIsUpperAndLower"
        And the inline error message "pwIsUpperAndLower" is displayed
        Then the "1 Capital and Small Letter" password criteria is enabled

      Scenario: Password field has mixed letter and numbers
        When the member enters registration details for "pwIsMixChar"
        And the inline error message "pwIsMixChar" is displayed
        Then the "Mix of letters & numbers" password criteria is enabled

      Scenario: Password field has at least 1 accepted special character
        When the member enters registration details for "pwIsWithSpecialChar"
        And the inline error message "pwIsWithSpecialChar" is displayed
        Then the "At least 1 accepted special character" password criteria is enabled

      Scenario: Password and Confirm Password field do not match
        When the member enters registration details for "cpwIsNotMatched"
        Then the inline error message "cpwIsNotMatched" is displayed

      Scenario: Password and Confirm Password field matches
        When the member enters registration details for "cpwIsMatched"
        Then no inline error message is displayed for "cpwIsMatched"














#      Scenario: Member should be able to proceed when all required fields are completed correctly
#        When the member enters valid registration details
#        And the member ticks the SMAC Terms and Conditions and Data Privacy Policy
#        And the member clicks the Proceed button
#        Then the Link Card Page should be displayed










