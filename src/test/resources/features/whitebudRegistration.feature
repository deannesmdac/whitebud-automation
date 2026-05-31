Feature: Whitebud Registration
  Background:
    Given Member navigates to the SMAC Web Registration Portal

      Scenario: SMAC Web Registration Portal is displayed
        Then the "SMAC Web Registration" portal is displayed

  Scenario Outline: Validate required fields
    When the member leaves the "<FieldName>" field blank
    Then the inline error message for missing "<FieldName>" is "<ErrorMessage>"
    Examples:
      | FieldName    | ErrorMessage
      | FirstName    | This field is required.
      | LastName     | This field is required.
      | Birthday     | This field is required.
      | MobileNumber | Please enter a complete mobile number.
      | Password     | Password not strong enough.


#      Scenario: First Name field is required
#        When the member leaves the "First Name" field blank
#        Then the inline error message "This field is required." should be displayed
#
#      Scenario: Numeric character is entered in the First Name field
#        When the member enters numeric characters in the First Name field
#        Then the inline error message "Enter a valid first name." is displayed







