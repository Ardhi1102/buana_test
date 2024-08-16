@DisappearingElement @Buana
Feature: Disappearing Element

  @TC09
  Scenario: Verify the disappearing elements on the page
    Given User already on the landing page
    When User click on the "Disappearing Elements" link
    Then User should see a list of elements
    And User should log each element's text
    And User should verify that the "Gallery" element is not present

  @TC10
  Scenario: Verify functionality on home tab
    Given User already on the landing page
    When User click on the "Disappearing Elements" link
    Then User should see a list of elements
    And User click on the home tab
    Then User should see a list of elements
