Feature: Title of your feature
  I want to use this template for my feature file

  Background: To load the browser and url
    Given I open the 'browser'
    And I enter the blog url

  Scenario Outline: To enter the search data in the search option and system looks for the
    And I click on the left side 'Floating Dock'
    And I enter '<searchItem>' in the search field
    And I press enter key

    Examples: 
      | searchItem |
      | world cup  |
