@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario:Steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
    When I type "cheese" into element with xpath "//input[@id='ybar-sbq']"
    And I click on element using JavaScript with xpath "//button[@id='ybar-search']"
    Then I wait for element with xpath "//div[contains(@class,'visible-pivots')]" to be present
    And  element with xpath "//div[@id='results']" should contain text "Cheese"

  @predefined3
  Scenario: Steps for bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    When I type "apple fruit" into element with xpath "//input[@id='sb_form_q']"
    And I enter element with xpath "//input[@id='sb_form_q']"
    Then I wait for element with xpath "//body/div[@id='b_content']/main[1]" to be present
    And element with xpath "//div[@id='b_content']" should contain text "apple"
    
  @predefined4
  Scenario: Steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    When I type "stanford" into element with xpath "//input[@id='text']"
    And I click on element using JavaScript with xpath "//button[contains(@class,'button_theme_search')]"
    Then I wait for element with xpath "//div[contains(@class,'main__center')]" to be present
    And element with xpath "//div[contains(@class,'main__center')]" should contain text "stanford"
    