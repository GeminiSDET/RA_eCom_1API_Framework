Feature: Apply Offers to Cart

Scenario Outline: Apply FLAT offers based on customer segment
    Given I add a FLAT offer of <offerValue> <offerType> for segment <segment> for restaurant <restaurantId>
    When I apply the offer on cart with value <cartValue> for user <userId> and restaurant <restaurantId>
    Then the final cart value should be <expectedFinalPrice>

Examples:
  | offerValue | offerType | segment | restaurantId | cartValue | userId | expectedFinalPrice |
  | 10         | FLATX     | p1      | 1            | 200       | 1      | 190                |
  | 10         | FLATP     | p1      | 1            | 200       | 1      | 180                |
