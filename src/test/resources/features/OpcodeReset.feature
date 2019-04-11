@smoke
Feature: Opcodes Reset and Enable

  Background:
    Given user is on Home Page
    When user navigates to My Opcodes tab
    Then [Not] the button Enable and Reset should be enabled

  Scenario: All checkbox should enable Enable and Reset button
    When user check all Checkbox
    Then the button Enable and Reset should be enabled