Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
   Given Add Place Payload with "<name>" "<language>" "<address>"
   When user calls "AddPlaceAPI" with "POST" http request
   Then the API call is success with status code 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"
   And verify place_Id created maps to "<name>" using "getPlaceAPI"
   
Examples: 
   |name         |language       |address      |
   |PuneHouse    |Marathi        |World Trade  |
#  |ChennaiHouse |Tamil          |Beach Trade  |
 
 Scenario: Verify if Delete place functionality is working
 
   Given DeletePlace Payload
   When user calls "deletePlaceAPI" with "POST" http request
   Then the API call is success with status code 200
   And "status" in response body is "OK"