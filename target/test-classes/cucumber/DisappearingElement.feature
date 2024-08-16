@DisappearingElement
  Feature: Disappearing Element

    Scenario: Verify the disappearing elements on the page
      Given I am on the landing page
      When I click on the "Disappearing Elements" link
      Then I should see a list of elements
      And I should log each element's text
      And I should verify that the "Gallery" element is not present

    Scenario: Verify that an invalid link does not exist on the page
      Given I am on the landing page
      When I click on the "Disappearing Elements" link
      Then I should see a list of elements
      And I click on the home tab
      Then I should see a list of elements