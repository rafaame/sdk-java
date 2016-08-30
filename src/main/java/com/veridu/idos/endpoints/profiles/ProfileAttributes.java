package com.veridu.idos.endpoints.profiles;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.google.gson.JsonObject;
import com.veridu.idos.endpoints.AbstractEndpoint;
import com.veridu.idos.exceptions.SDKException;

/**
 * Profile Attributes Endpoint Class
 * 
 * @version 2.0
 *
 */
public class ProfileAttributes extends AbstractEndpoint {
    /**
     * Class Constructor
     */
    public ProfileAttributes() {

    }

    /**
     * Lists all profiles attributes
     * 
     * @param username
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject listAll(String username) throws SDKException {
        return this.fetch("GET", "profiles/" + username + "/attributes");
    }

    /**
     * Retrieves an attribute given its attribute name
     * 
     * @param username
     * @param attributeName
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject getOne(String username, String attributeName) throws SDKException {
        return this.fetch("GET", "profiles/" + username + "/attributes" + attributeName);
    }

    /**
     * Creates a new attribute passing the name of the attribute
     * 
     * @param username
     * @param attributeName
     * @param attributeValue
     * @return JsonObject response
     * @throws SDKException
     * @throws UnsupportedEncodingException
     */
    public JsonObject create(String username, String attributeName, String attributeValue)
            throws SDKException, UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", attributeName);
        data.put("value", attributeValue);
        return this.fetch("POST", "profiles/" + username + "/attributes", this.queryBuilder(data));
    }

    /**
     * Deletes an attribute given its attributeName
     * 
     * @param username
     * @param attributeName
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject delete(String username, String attributeName) throws SDKException {
        return this.fetch("DELETE", "profiles/" + username + "/attributes/" + attributeName);
    }

    /**
     * Deletes all attributes related to the given username
     * 
     * @param username
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject deleteAll(String username) throws SDKException {
        return this.fetch("DELETE", "profiles/" + username + "/attributes");
    }

}
