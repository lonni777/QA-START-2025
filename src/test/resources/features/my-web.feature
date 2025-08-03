Feature: training scenarios

#  Background:
#    Given I load google page
#    Given I accept cookies if they are present
#
#  Scenario Outline: Google and random people test
#    Given request <amount> random people from API
#    And I store those people in database
#    And I pick a single random person from DB
#
#    When I set search to random persons name
#    Then Search field contains random persons name
#    Examples:
#      | amount |
#      | 3      |
#      | 5      |


  Scenario: Google and random people test
    Given request 3 random people from API as "crowd1"
    And I store "crowd1" in database
    And I pick a single random person from DB as "random_person"
    Given I load google page
    Given I accept cookies if they are present
    When I set search to "random_person"
    Then Search field contains "random_person"









