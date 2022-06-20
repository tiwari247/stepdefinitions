@Customer
Feature: Customer feature
  I want to use this template for my feature file

Background: User is logged in
		Given I open a browser and navigated to the login page
    When I enter username "mngr417005" and password "qebyvEj"
    And I click login
    Then Manager home page should be displayed
    And validate managerID "mngr417005"
    
    Scenario Outline: Add new Customer
    When I click on New Customer button
    And I give customer details like "<Name>", "<gender>", "<dob>", "<address>", "<city>", "<state>", "<pin>", "<mob>", "<email>" and "<password>"
    And click on submit button
    Then Customer should be able to see successful registeration message
    And  a customerID should be generated

    Examples: 
      | Name | gender | dob        | address   | city  | state  | pin  | mob       | email        | password |
      | XYZ  | m   | 1993-08-09 | XYZAddress|XYZCity|XYZState|100100|12345678900|XYZ24766@xyz.com  |XYZPassword|
