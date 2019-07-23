@location @smoke
Feature: campus locations

  @va-dark
  Scenario: VA - dark side

    Given user on the login page
    When  user logs in using "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
    And   user clicks the login button
    Then locations should be "dark-side"


  @va-light
  Scenario: VA - dark side

    Given user on the login page
    When  user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    And   user clicks the login button
    Then locations should be "light-side"


  @il
  Scenario: VA - dark side

    Given user on the login page
    When  user logs in using "fbawmeb7@studiopress.com" and "sherilyngohn"
    And   user clicks the login button
    Then locations should be "il"


    @campusnames
    Scenario Outline: Verify campus names

      Given user on the login page
      When  user logs in using "<email>" and "<password>"
      And   user clicks the login button
      Then locations should be "<campus>"

    Examples:
      |email                           |password      |campus    |
      |efewtrell8c@craigslist.org      |jamesmay      |dark-side |
      |bbursnoll8d@acquirethisname.com |johndillinger |dark-side |
      |aneagle7h@miibeian.gov.cn       |bennetttomanek|light-side|
      |ewrist7i@livejournal.com        |marianndewi   |light-side|
      |fbawmeb7@studiopress.com        |sherilyngohn  |il        |
      |dhughillb8@gov.uk               |celiefaltin   |il        |
      |wamiss8p@businesswire.com       |olagrills     |dark-side |
      |bmurkus8q@psu.edu               |alicasanbroke |dark-side |
      |mstacey8r@imdb.com              |skylargiblin  |dark-side |
      |ecrasford8s@dagondesign.com     |bricesiddell  |dark-side |
      |gwilloway8t@nih.gov             |morrievondrach|dark-side |
      |csummergill83@blinklist.com     |edycaton      |light-side|
      |strayford84@e-recht24.de        |carlosmichie  |light-side|
      |teacherva5@gmail.com            |maxpayne      |light-side|
      |cbrose86@cbslocal.com           |garrikheis    |light-side|

      |kpenvarne87@w3.org              |marianspinley |light-side|

      |kpenvarne87@w3.org              |marianspinley |light-side|

