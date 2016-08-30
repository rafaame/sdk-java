package com.veridu.idos.samples.profiles;

import java.io.UnsupportedEncodingException;

import com.google.gson.JsonObject;
import com.veridu.idos.ProfileFactory;
import com.veridu.idos.exceptions.InvalidToken;
import com.veridu.idos.exceptions.SDKException;
import com.veridu.idos.settings.Config;
import com.veridu.idos.utils.Utils;

public class ProfileFeatureSamples {
    public static void main(String[] args) throws InvalidToken, SDKException, UnsupportedEncodingException {
        /**
         * JsonObject used to parse the response
         * 
         * @see https://github.com/google/gson
         */
        JsonObject parsed = null;
        /**
         * ProfileFactory is a class that instantiate all endpoints as their methods
         * (getEndpointName) are called. The endpoints don't need to be
         * instantiated one by one. You just need to call the
         * factory.getEndpoint and its going to be instantiated and available to
         * call its methods. In other words, it means that all endpoints is
         * going to pass by an ProfileFactory Class, and accessed through this object
         * 
         */
        String token = Utils.generateToken(Config.issuerPublicKey, Config.issuerPrivateKey, Config.issuerPublicKey);

        ProfileFactory profileFactory = new ProfileFactory(token);

        /* Username necessary for all requests of this endpoint */
        String username = "9fd9f63e0d6487537569075da85a0c7f2";

        /**
         * Gets the response from the API listing all features
         */
        JsonObject json = profileFactory.getFeature().listAll(username);

        /**
         * Prints the json
         */
        System.out.println(json);

        /**
         * Gets the response from the API trying to create a new feature
         */
        json = profileFactory.feature.create(username, "Name", "value");

        /**
         * Get the response form the API getting one feature
         */
        json = profileFactory.feature.getOne(username, "feature-slug");

        /**
         * Prints the array response
         */
        System.out.println(json.get("data").getAsJsonObject());

        /**
         * Updates the feature giving the feature-slug
         */
        json = profileFactory.feature.update(username, "feature-slug", "new name", "new value");

        /**
         * Prints the json response
         */
        System.out.println(json);

        /**
         * Deletes the credential feature giving the feature name
         */
        json = profileFactory.feature.delete(username, "feature-slug");

        /**
         * Prints the status of the request
         */
        System.out.println(json.get("status").getAsBoolean());

        /**
         * Deletes all features
         */
        json = profileFactory.feature.deleteAll(username);

        /**
         * Prints the number of deleted features
         */
        System.out.println(json.get("deleted").getAsInt());

        /**
         * Deletes all profile features related to the username
         */
        json = profileFactory.feature.deleteAll(username);

        /**
         * Prints the number of deleted features
         */
        System.out.println(json.get("deleted").getAsInt());
    }
}
