Feature: Get quote for home insurance

  Scenario: User should be able to get a quote for home insurance

    Given User is already on Home Page
    Then title of page is "Insurance Quotes for Home, Auto, & Life : Farmers Insurance"
    When User clicks on Home button
    Then User should see "Get a home insurance quote" and Zip_Code field
    Then User fills Zip_Code with "91367" in order get quote
    And User clicks on Get a quote button
    Then User should see text "Tell us about yourself"
    And User types "Agajan" in first name field
    And User types "Allaberdiyev" in last name field
    And User types "05/01/1990" in Date of Birth field
    And User clicks on "Male" button in Gender field
    And User selects "Engineer" in Occupation field
    And User selects "Single" in Marital Status field
    And User types "6303 Owensmouth Ave" in Street Address field
    And User types "Woodland Hills" in city field
    And User types "91367" in zip code field
    And User selects "Townhouse" in property type field
    And User clicks Continue button


