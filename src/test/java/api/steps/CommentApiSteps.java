package api.steps;

import api.models.CommentId;
import api.models.Result;
import api.models.args.BodyArgs;
import io.restassured.response.Response;

import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class CommentApiSteps extends BaseApiSteps {

    public String getComment(Integer commentid) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new CommentId(commentid))
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        Result result = response.as(Result.class);
        response.prettyPrint();
        return result.getResult().toString();
    }


}
