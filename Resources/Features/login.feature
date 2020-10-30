Feature:  Login functionality

  Scenario Outline:  Validate Login functionality with valid credentails
    Given I have application url and i am on login page
    When I enter username "<username>"
    And I Enter password "<password>"
    And I click on login button
    Then Secure Area page is displayed

    Examples:
      |	username 	|	password						|
      |	tomsmith	|	SuperSecretPassword!|
			
	Scenario Outline:  Validate Login functionality with "<testname>"
    Given I have application url and i am on login page
    When I enter username "<username>"
    And I Enter password "<password>"
    And I click on login button
    Then Error Message "<ErrorMessage>" is displayed in login page

    Examples:
      |testname													|username |password				| ErrorMessage							|
      |valid_username_invalid_password	|tomsmith	|abc1						|	Your password is invalid! |
      |invalid_username_valid_password	|					|								| Your username is invalid! |				
			|blank_username_valid_password		|					|secret_sauce		| Your username is invalid! |
			|valid_username_blank_password		|tomsmith	|								|	Your password is invalid!	|
			|blank_username_and_blank_password|					|								| Your username is invalid! |