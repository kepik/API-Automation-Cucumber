@api
Feature: API Automation

  @api-getdata-normal
  Scenario: test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validate status code is equal 200
    Then validate response body get list users
    Then validate response json JSONSchema "get_list_users_normal.json"

  @api-create-normal
  Scenario: test get list data normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validate status code is equal 201
    Then validate response body create new user
    Then validate response json JSONSchema "post_create_new_user_normal.json"

  @api-update-normal
  Scenario: test get list data normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validate status code is equal 201
    Then validate response body create new user
    And hit api update user data
    Then validate status code is equal 200
    Then validate response body update data user
    Then validate response json JSONSchema "patch_update_user_normal.json"

  @api-delete-normal
  Scenario: test get list data normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validate status code is equal 201
    Then validate response body create new user
    Given prepare url for "DELETE_USER"
    And hit api delete user data
    Then validate status code is equal 204