Feature: Pet Management in the PetStore

  Background:
    Given the user has access to petstore API "https://petstore.swagger.io/v2"

  @Services
  @Services1
  Scenario: Add a Pet to the Store
    When the user adds a pet with the name "Firulais" and status "available"
    Then the response must contain the name "Firulais" and status code 200

  @Services
  @Services2
  Scenario: Query the Entered Pet by ID
    Given that the user registers a pet with the name "Firulais" and the status "available"
    When querying the pet by ID
    Then the response must contain the pet's ID and name and status code 200

  @Services
  @Services3
  Scenario: Update the Pet's Name and Status
    Given the user wants to update the pet
    When changing the name to "Rocky" and the status to "sold"
    Then the pet must reflect the changes and status code should be 200

  @Services
  @Services4
  Scenario: Query Pet by Status
    Given the user searches for pets by status
    When querying pets with the status "sold"
    Then the list must contain pets with the status "sold" and status code 200