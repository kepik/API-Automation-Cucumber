package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.*;


//hit urls
public class Models {
    private static RequestSpecification request;
    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 17f27fd87e8e0ff819c3c09855241ff3b0f30008af47463af7571b6389b80f6e");
    }
    // set url
    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUser(String endpoint) {
        String name = "Test New User";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name",name);
        payload.put("gender",gender);
        payload.put("email",email);
        payload.put("status",status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response patchUpdateUser(String endpoint, String user_id) {
        setupHeaders();

        String name = "Test New Edit";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name",name);
        payload.put("gender",gender);
        payload.put("email",email);
        payload.put("status",status);

        String finalEndpoint = endpoint +"/"+ user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response deleteUserData(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint +"/"+ user_id;
        return request.when().delete(finalEndpoint);
    }
}
