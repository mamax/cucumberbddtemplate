@smoke
Feature: Offline Account Images
  Scenario Outline: Find Archive button get enabled positive case
    Given user is on Home Page
    When user navigates to Archive tab
    When user enters host <host> into search field :
    Then [Not] the button Find Archive should be enabled
    Examples:
      | host  |
      | CH2     |
      | DAL     |

  Scenario Outline: Find Archive button not enabled negative case
    Given user is on Home Page
    When user navigates to Archive tab
    When user enters host <host> into search field :
    When user selects <date> on calendar :
    Then [Not] the button Find Archive should be enabled
    Examples:
      | host  | date       |
      | U       | 06/30/2018 |
      | DA      | 06/30/2018 |
      | ERW4    | 06/30/2018 |
      | JYE3R   | 06/30/2018 |
      | PIKE95  | 06/30/2018 |

#  Scenario Outline: Requested archive not found
#    Given I am on the home page
#    Then [Not] the button Enable and Reset should be enabled
#    When I go to Archive tab
#    When The user enter host <opcode> into search field :
#    When the user selects <date> on calendar :
#    Then the button Find Archive should be enabled
#    When the user clicks Find Archive button
#    Then the <opcode> should be equal to snapshot date :
#    And the Requested archive not found message appears
#    When the user clicks Change button
#    Then the <opcode> should be equal to Host Code :
#    Then the button Find Archive should be enabled
#    Examples:
#      | opcode  | date       |
#      | DAL     | 02/06/2017 |
#      | DAL     | 04/03/2018 |
#      | DAL     | 09/28/2012 |
#      | DAL     | 06/27/2024 |
#
#  Scenario Outline: Request Data Successful
#    Given I am on the home page
#    Then [Not] the button Enable and Reset should be enabled
#    When I go to Archive tab
#    When The user enter host <opcode> into search field :
#    When the user selects <date> on calendar :
#    Then the button Find Archive should be enabled
#    When the user clicks Find Archive button
#    Then the <opcode> should be equal to snapshot date :
#    When the user enters <account> to search for
#    When the user clicks Request Data button
#    Then your request was sent successfully
#       Examples:
#      | opcode  | date       | account   |
#      | DAL     | 06/30/2018 | 1-12345   |
#      | DAL     | 06/28/2018 | 12-12345  |
#
#  @ignore
#  Scenario Outline: Request Data older than 90 days
#    Given I am on the home page
#    Then [Not] the button Enable and Reset should be enabled
#    When I go to Archive tab
#    When The user enter host <opcode> into search field :
#    When the user selects <date> on calendar :
#    Then the button Find Archive should be enabled
#    When the user clicks Find Archive button
#  # When the user selects end of month date
#    Then the <opcode> should be equal to snapshot date :
#    When the user enters <account> to search for
#    When the user clicks Request Data button
#    Then your request was sent successfully
#    Examples:
#      | opcode  | date       | account   |
#      | DAL     | 07/15/2018 | 1-12345   |
#      | DAL     | 07/28/2018 | 12-12345  |