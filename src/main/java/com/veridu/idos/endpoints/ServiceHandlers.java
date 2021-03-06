package com.veridu.idos.endpoints;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.veridu.idos.exceptions.InvalidToken;
import com.veridu.idos.exceptions.SDKException;
import com.veridu.idos.utils.IdOSAuthType;
import com.veridu.idos.utils.Filter;

/**
 * ServiceHandlers Endpoint class
 * 
 * @version 2.0
 */
public class ServiceHandlers extends AbstractEndpoint {
    /**
     * Constructor Class
     */
    public ServiceHandlers(HashMap<String, String> credentials) throws InvalidToken {
        super(credentials, IdOSAuthType.MANAGEMENT);
    }

    /**
     * Lists all service handlers related to the given company token
     * 
     * @return JsonObject response
     */
    public JsonObject listAll() throws SDKException {
        return this.fetch("GET", "service-handlers");
    }

    /**
     * Retrieves a service handler given its service handler id
     * 
     * @param serviceHandlerId
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject getOne(int serviceHandlerId) throws SDKException {
        return this.fetch("GET", "service-handlers/" + serviceHandlerId);
    }

    /**
     * Creates a new service handler
     * 
     * @param serviceId
     * @param listens
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject create(int serviceId, ArrayList<String> listens) throws SDKException {
        JsonObject data = new JsonObject();
        data.addProperty("service_id", serviceId);
        JsonArray listensArray = new JsonArray();
        for (String list : listens) {
            listensArray.add(list);
        }
        data.add("listens", listensArray);
        return this.fetch("POST", "service-handlers", data);
    }

    /**
     * Updates a service handler given its id
     * 
     * @param serviceHandlerId
     * @param listens
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject update(int serviceHandlerId, ArrayList<String> listens) throws SDKException {
        JsonObject data = new JsonObject();
        JsonArray listensArray = new JsonArray();
        for (String list : listens) {
            listensArray.add(list);
        }
        data.add("listens", listensArray);

        return this.fetch("PUT", "service-handlers/" + serviceHandlerId, data);
    }

    /**
     * Deletes a service handler given its id
     * 
     * @param serviceHandlerId
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject delete(int serviceHandlerId) throws SDKException {
        return this.fetch("DELETE", "service-handlers/" + serviceHandlerId);
    }

    /**
     * Deletes all service handlers related to the given company
     * 
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject deleteAll() throws SDKException {
        return this.fetch("DELETE", "service-handlers");
    }
}
