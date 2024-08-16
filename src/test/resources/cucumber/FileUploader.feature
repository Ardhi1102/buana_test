@FileUpload @Buana
Feature: File Upload

  @TC06
  Scenario: User uploads a valid file successfully
    Given User is on the homepage
    When User navigates to the File Upload page
    And User selects a valid file to upload
    And User submits the file
    Then The file should be uploaded successfully

  @TC07
  Scenario: User attempts to upload a file without selecting one
    Given User is on the homepage
    When User navigates to the File Upload page
    And User submits the file without selecting any file
    Then User should see an error message indicating no file was selected

  @TC08
  Scenario: User uploads an invalid file type
    Given User is on the homepage
    When User navigates to the File Upload page
    And User selects an invalid file type to upload
    And User submits the file
