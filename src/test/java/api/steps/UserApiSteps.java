package api.steps;

import api.models.BoardInfo;
import api.models.UserInfo;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;

import java.util.List;

import static api.enums.UserRoles.ADMIN;
import static api.enums.UserRoles.USER;
import static api.methods.Users.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class UserApiSteps extends BaseApiSteps {
    public String createUser(String username, String pass) {
        CreateUser args = CreateUser.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .role(ADMIN.getRole())
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        response.prettyPrint();
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public boolean deleteUser(Integer userId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId((userId)))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }


    public String getUser(Integer userId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserId(userId))
                .method(GET_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        Result result = response.as(Result.class);
        response.prettyPrint();
        return result.getResult().toString();
    }
}
