Feature: Create, update, delete students

  @wip
  Scenario: Add a student
    Given the user has access token as a student
    When the user creates a new student
    Then the new student should not be created
    And the new student information should be in the database
    And the user should be able to login with the new student info


    @wip
  Scenario: Exclude a student
    Given the user has access token as a student
    And there is a student available in
    When student deleted using the
    Then the student should be deleted
    And the new student information should not be in the database
    And the user should not be able to login with the new student info
