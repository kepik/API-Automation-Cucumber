package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setUrl, global_id;
    Response res;

    public void prepareUrl(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setUrl = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setUrl = Endpoint.CREATE_NEW_USER;
                break;
            case "UPDATE_USER_DATA":
                setUrl = Endpoint.UPDATE_USER_DATA;
                break;
            case "DELETE_USER":
                setUrl = Endpoint.DELETE_USER;
                break;
            default:
                System.out.println("input correct url");
        }
        //System.out.println("endpoint: "+setUrl);
    }
    public void hitApiGetListUsers() {
        // get url from Models file
        res = getListUsers(setUrl);
    }
    public void hitApiPostNewUser(){
        res = postCreateUser(setUrl);
        //System.out.println("create >> "+res.getBody().asString());
    }
    public void validateStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
        //System.out.println("status code: "+status_code);
    }
    public void validateResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }
    public void validateResponseJsonJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validateResponseCreate() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    public void hitApiUpdateUser() {
        res = patchUpdateUser(setUrl, global_id);
        //System.out.println("update >> "+res.getBody().asString());
    }
    public void validateResponseUpdate() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    public void hitApiDeleteUser() {
        res = deleteUserData(setUrl, global_id);
        //System.out.println("delete >> "+res.getBody().asString());
    }
}
