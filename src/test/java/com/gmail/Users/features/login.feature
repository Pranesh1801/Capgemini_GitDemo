Feature: Store login
This feature deals with the login 

  Background:
    Given I navigate to login page

  @TC1
  Scenario: Login with correct username and correct password
  # Given I navigate to login page
  # And I entered "mercury" and "mercury"
    And I clicked signin button
    Then Its navigated to the HomePage

  @TC2
  Scenario: Login with correct username and invlid password
  # Given I navigate to login page
  # And I entered "aspirine" and "aspirine"
    But Invalid pwd
    And I clicked signin button
    Then Its navigated to the HomePage

  @TC3
  Scenario: Login with correct username and correct password
  # Given I navigate to login page
    And I entered
      | check    | mate      |
      | mercury  | mercury   |
      | aspirine | aspirine  |
      | boom     | shakalaka |
    And I clicked signin button
    Then Its navigated to the HomePage

  @TC4
  Scenario: Login with correct username and correct password
  #Given I navigate to login page
    And I test the following credentials
      | check    | mate      |
      | mercury  | mercury   |
      | aspirine | aspirine  |
      | boom     | shakalaka |
    Then Its navigated to the HomePage

  Scenario Outline: Data driven testing using scenario
    Given I navigate to login page
  # And I entered username and password
    When I insert "<username>" and "<password>"
    And I clicked signin button
    Then Its navigated to the HomePage

    Examples:
      | username | password |
      | mercury  | mercury  |
      | mercury  | aaa      |
      | bbb      | mercury  |
