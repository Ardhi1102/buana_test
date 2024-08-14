@Login
Feature: Login

  @TC01
  Scenario: User login with valid credential
    Given User open basic authentication page
    Then Verify user success login

  @TC02
  Scenario: User login with incorrect credential
    Given User open basic authentication page with incorrect credential
    Then Verify user failed to login

  @TC03
  Scenario: User login with empty username
    Given User open basic authentication page with empty username
    Then Verify user failed to login

    @TC04
  Scenario: User login with empty password
    Given User open basic authentication page with empty password
    Then Verify user failed to login

      @TC05
  Scenario: User login with empty username and password
    Given User open basic authentication page with empty username and password
    Then Verify user failed to login
