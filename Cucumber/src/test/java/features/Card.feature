Feature: saucedemo application Demo

  Scenario Outline: User should able to add Product to Card
    Given user should naviagate to the application
    And User Should entre "<username>" and "<password>"
    And Click Add to card button
    Then Card count should be updated

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |
