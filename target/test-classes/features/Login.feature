Feature: Login
  
  @tag1
  Scenario Outline: Verify Login Section
    Given I open a browser and navigated to the login page
    When I enter username "<username>" and password "<password>"
    And I click login
    Then Manager home page should be displayed
    And validate managerID "<username>"

    Examples: 
      | username  | password |
      | mngr417005| qebyvEj  |
