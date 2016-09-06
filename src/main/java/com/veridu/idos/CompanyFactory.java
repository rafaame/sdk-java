package com.veridu.idos;

import com.veridu.idos.endpoints.companies.Companies;
import com.veridu.idos.endpoints.companies.Credentials;
import com.veridu.idos.endpoints.companies.Hooks;
import com.veridu.idos.endpoints.companies.Members;
import com.veridu.idos.endpoints.companies.Permissions;
import com.veridu.idos.endpoints.companies.ProfileTags;
import com.veridu.idos.endpoints.companies.ServiceHandlers;
import com.veridu.idos.endpoints.companies.Services;
import com.veridu.idos.endpoints.companies.Settings;
import com.veridu.idos.exceptions.InvalidToken;
import com.veridu.idos.utils.IdOSUtils;

/**
 * CredentialFactory Endpoint creates all Endpoints
 *
 */
public class CompanyFactory {

    private String companyToken;

    /**
     * Companies object
     */
    private Companies company;
    /**
     * Permissions object
     */
    private Permissions permission;

    /**
     * Credentials Endpoint object
     */
    private Credentials credential;

    /**
     * Settings Endpoint object
     */
    private Settings setting;

    /**
     * Members Endpoint object
     */
    private Members member;

    /**
     * Hooks Endpoint object
     */
    private Hooks hook;

    /**
     * ProfileTags Endpoint object
     */
    private ProfileTags tag;

    /**
     * Services Endpoint object
     */
    private Services service;

    /**
     * Service Handlers Endpoint object
     */
    private ServiceHandlers serviceHandler;

    /**
     * Class constructor
     * 
     * @param companyToken
     * @throws Emptytoken
     */

    public CompanyFactory(String token) throws InvalidToken {
        if ((token == null) || token.isEmpty())
            throw new InvalidToken();

        this.companyToken = token;
    }

    public CompanyFactory(String privateKey, String publicKey) {
        this.companyToken = IdOSUtils.generateCompanyToken(privateKey, publicKey);
    }

    public CompanyFactory(String privateKey, String publicKey, String subject) {
        this.companyToken = IdOSUtils.generateCompanyToken(privateKey, publicKey, subject);
    }

    /**
     * Instantiates Companies endpoint
     * 
     * @return
     * 
     * @throws Emptytoken
     */
    public Companies getCompany() throws InvalidToken {
        if (!(this.company instanceof Companies))
            this.company = new Companies(this.companyToken);
        return this.company;
    }

    /**
     * Instantiates Permissions endpoint
     * 
     * @return
     * @throws InvalidToken
     */
    public Permissions getPermission() throws InvalidToken {
        if (!(this.permission instanceof Permissions))
            this.permission = new Permissions(this.companyToken);
        return this.permission;
    }

    /**
     * Instantiates Credentials endpoint
     * 
     * @return
     * @throws InvalidToken
     */
    public Credentials getCredential() throws InvalidToken {
        if (!(this.credential instanceof Credentials))
            this.credential = new Credentials(this.companyToken);
        return this.credential;
    }

    /**
     * Instantiates Settings endpoint
     * 
     * @return
     * @throws InvalidToken
     */
    public Settings getSetting() throws InvalidToken {
        if (!(this.setting instanceof Settings))
            this.setting = new Settings(this.companyToken);
        return this.setting;
    }

    /**
     * Instantiates Members endpoint
     * 
     * @return
     * @throws InvalidToken
     */
    public Members getMember() throws InvalidToken {
        if (!(this.member instanceof Members))
            this.member = new Members(this.companyToken);
        return this.member;
    }

    /**
     * Instantiates Hooks endpoint
     * 
     * @return
     * @throws InvalidToken
     */

    public Hooks getHook() throws InvalidToken {
        if (!(this.hook instanceof Hooks))
            this.hook = new Hooks(this.companyToken);
        return this.hook;
    }

    /**
     * Instantiates Tag endpoint
     * 
     * @return ProfileTags instance
     * @throws InvalidToken
     */
    public ProfileTags getTag() throws InvalidToken {
        if (!(this.tag instanceof ProfileTags))
            this.tag = new ProfileTags(this.companyToken);
        return this.tag;
    }

    /**
     * Instantiates Services endpoint
     * 
     * @return Services instance
     * @throws InvalidToken
     */
    public Services getService() throws InvalidToken {
        if (!(this.service instanceof Services))
            this.service = new Services(this.companyToken);
        return this.service;
    }

    public ServiceHandlers getServiceHandler() throws InvalidToken {
        if (!(this.serviceHandler instanceof ServiceHandlers))
            this.serviceHandler = new ServiceHandlers(this.companyToken);
        return this.serviceHandler;
    }

}
