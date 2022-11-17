@Smoke
Feature: Going to https://monstar-lab.com/vn/ through Google search


  @TC_01
  Scenario: Verify that the user can search browserstack through Google search
    Given I'm on the Google search
    When I enter "browserstack" into search text box
    And I click Search button
    Then I verify that "BrowserStack" site is at the first in search result


  @TC_02
  Scenario: Verify that the user can open https://monstar-lab.com/vn/ through Google search
    Given I'm on the Google search
    When I enter "monstar lab" into search text box
    And I click Search button
    Then I verify that "Monstar Lab" site is at the first in search result