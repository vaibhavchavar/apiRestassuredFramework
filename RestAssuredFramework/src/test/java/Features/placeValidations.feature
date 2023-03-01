Feature: validation of add place Api
#feature files for Api
@AddPlace
Scenario Outline: Verify if place is being Sucessfully added using AddplaceApi
    Given add place payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "Post" http request
    When user calls "getPlaceApi" with "Get" http request
    Then the api call is success with status code 200
    And "status" in response body is "Ok"
    And "scope" in response body is "App"
    And verify place_Id created maps to "<name>" using "getPlaceApi"
    
    Examples:
    |name  |language|address   |
    |Ahouse|english |anyaddress|
   |Bhouse|Hindi   | address |
   
@DeletePlace   
Scenario: verify if delete place functionality is working
     Given delete place payload
     When user calls "deletePlaceAPI" with "Post" http request
     Then the api call is success with status code 200
     And "status" in response body is "Ok"
        
  
