Feature: Get all Vehicles

  Background:
    * url baseUrl

  Scenario: create booking - works

  def mustang = {
  "model": "Mustang",
  "id": 1,
  "brand": "Ford"
  }

  def ram  = {
  "model": "ram",
  "id": 2,
  "brand": "Ford"
  }

    Given path 'vehicle'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And print response
    And match response contains [{'id': 1,'model': 'Mustang','brand': 'Ford'},{'model': 'Ram','id': 2,'brand': 'Ford'}]


