package com.veridu.idos.samples.profiles;

import com.google.gson.JsonObject;
import com.veridu.idos.Factory;
import com.veridu.idos.exceptions.SDKException;
import com.veridu.idos.settings.Config;
import com.veridu.idos.utils.Utils;

public class ProfileFlagSamples {

    public static void main(String[] args) throws SDKException {
        /**
         * JsonObject used to parse the response
         * 
         * @see https://github.com/google/gson
         */
        JsonObject parsed = null;
        /**
         * Factory is a class that instantiate all endpoints as their methods
         * (getEndpointName) are called. The endpoints don't need to be
         * instantiated one by one. You just need to call the
         * factory.getEndpoint and its going to be instantiated and available to
         * call its methods. In other words, it means that all endpoints is
         * going to pass by an Factory Class, and accessed through this object
         * 
         */
        String token = Utils.generateToken(Config.issuerPublicKey, Config.issuerPrivateKey, Config.issuerPublicKey);

        Factory factory = new Factory(token);

        /* Username necessary for all requests of this endpoint */
        String username = "9fd9f63e0d6487537569075da85a0c7f2";

        /**
         * Gets the response from the API listing all flags
         */
        JsonObject json = factory.getFlag().listAll(username);

        /**
         * Prints the json
         */
        System.out.println(json);

        /**
         * Gets the response from the API trying to create a new flag
         */
        json = factory.flag.create(username, "flagName");

        /**
         * Get the response form the API getting one flag
         */
        json = factory.flag.getOne(username, "flagName");

        /**
         * Prints the array response
         */
        System.out.println(json.get("data").getAsJsonObject());

        /**
         * Deletes the flag created giving the flag name
         */
        json = factory.flag.delete(username, "flagName");

        /**
         * Prints the status of the request
         */
        System.out.println(json.get("status").getAsBoolean());

        /**
         * Deletes all profile flags related to the username
         */
        json = factory.flag.deleteAll(username);

        /**
         * Prints the number of deleted flags
         */
        System.out.println(json.get("deleted").getAsInt());

        /**
         * Deletes all profile flags related to the username
         */
        json = factory.flag.deleteAll(username);

        /**
         * Prints the number of deleted flags
         */
        System.out.println(json.get("deleted").getAsInt());
    }

}