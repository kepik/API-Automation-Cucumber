package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStepDef {
    ApiPage apiPage;
    public ApiStepDef(){
        this.apiPage = new ApiPage();
    }
    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrl(url);
    }
    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }
    @Then("validate status code is equal {int}")
    public void validateStatusCodeIsEqual(int status_code) {
        apiPage.validateStatusCode(status_code);
    }
    @Then("validate response body get list users")
    public void validateResponseBodyGetListUsers() {
        apiPage.validateResponseBodyGetListUsers();
    }
    @Then("validate response json JSONSchema {string}")
    public void validateResponseJsonJSONSchema(String filename) {
        apiPage.validateResponseJsonJSONSchema(filename);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostNewUser();
    }

    @And("hit api update user data")
    public void hitApiUpdateUserData() {
        apiPage.hitApiUpdateUser();
    }

    @And("hit api delete user data")
    public void hitApiDeleteUserData() {
        apiPage.hitApiDeleteUser();
    }
    @Then("validate response body create new user")
    public void validateResponseBodyCreateNewUser() {
        apiPage.validateResponseCreate();
    }

    @Then("validate response body update data user")
    public void validateResponseBodyUpdateDataUser() {
        apiPage.validateResponseUpdate();
    }
}
