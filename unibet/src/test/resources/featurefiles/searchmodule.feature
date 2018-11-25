Feature: To test the search feature functionalities

  Background: To load the browser and url
    Given I open the 'browser'
    And I enter the blog url
    Then 'Unibet Blog' gets loaded

  @Smoke @Regression
  Scenario Outline: To enter the search data in the search option and user is able to fetch the result.
    And I click on the left side 'Floating Dock'
    And I enter '<searchItem>' in the search field
    And I press 'Enter' key
    Then User is able to search the content

    Examples: 
      | searchItem  |
      | world cup   |
      | flat racing |

  @Regression
  Scenario: To verify that if testdata is not available in the database then system will display "No search results". Positive scenario
    And I click on the left side 'Floating Dock'
    And I enter 'Ssoimnegnh' in the search field
    And I press 'Enter' key
    Then User verifies that 'No search results' message displays as a result

  @Regression
  Scenario: To verify that if testdata is not available in the database then system will display "No search results". We will
    compare it with the negative Test Data. Negative scenario

    And I click on the left side 'Floating Dock'
    And I enter 'Ssoimnegnh' in the search field
    And I press 'Enter' key
    Then User verifies that 'No search results1' message displays as a result

  @Sanity
  Scenario Outline: To verify whether the links present post search are not broken-links
    And I click on the left side 'Floating Dock'
    And I enter '<searchItem>' in the search field
    And I press 'Enter' key
    Then User verifies that links present in the search result are working links

    Examples: 
      | searchItem |
      | world cup  |
