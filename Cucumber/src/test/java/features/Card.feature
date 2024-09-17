Feature: saucedemo application Demo

  Scenario Outline: User should able to add Product in Card
  
    
    And User Should entre "<username>" and "<password>"
    And Click Add to card button
    Then Card count should be updated

    @Test
    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      #| standard_user | secret_sauce |

    #@Div
    #Examples: 
      #| username      | password     |
      #| standard_user | secret_sauce |
      #| standard_user | secret_sauce |
