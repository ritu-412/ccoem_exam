@tag
Feature: Exam Category and subcategory Test

	Background:
	Given I landed on OEM Exam portal Page
	
	@Regression
  Scenario Outline: Category and subcategory Test cases.

    Given Logged in with email <email> and password <password>
    When I redirect to the category menu 
    And  Click on category Add button
    And  Fill the category name <category name> and description <category description> and submit the form
    Then Verify Category success message

    Examples: 
    
      | email                        | password       | category name      | category description             |
      | biswas1.soumyajit@gmail.com  | Test@1234      | Automation Testing | test test test description       |
     