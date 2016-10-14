/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.User.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.repackaged.com.google.gson.JsonElement;
import com.google.appengine.repackaged.com.google.gson.JsonObject;
import com.google.appengine.repackaged.com.google.gson.JsonParser;
import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.User.example.com",
                ownerName = "backend.myapplication.User.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    private final String API_USER_URL = "http://api.github.com/users/";

    @ApiMethod(name = "sayHi")
    public DataBean sayHi(@Named("name")String name) {
        DataBean response = new DataBean();
        response.setData("Hi, " + name);
        return response;
    }

    @ApiMethod(name = "getGithub", httpMethod = "GET")
    public DataBean getGithub(@Named("name") String userName) {
        DataBean response = new DataBean();
        JsonParser parser = new JsonParser();
        HttpClient client = new HttpClient();
        JsonObject json = parser.parse(client.get(API_USER_URL + userName)).getAsJsonObject();
        String numberOfRepos = json.get("public_repos").toString();
        String createdAt = json.get("created_at").toString();
        response.setData("Public repos of this user: " + numberOfRepos + "\nCreated at: " + createdAt);
        return response;
    }

}
