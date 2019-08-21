Feature: Create student permissions

 @studentCreates
  Scenario: Students should not be able to create
    Given the user has access token as a student
    When the user creates a new student
    Then the new student should not be created

  @teacherCreates
  Scenario: Teachers should be able to create
    Given the user has access token as a teacher
    When the user creates a new student
    Then the new student should be created