package com.shopping.controller;

import com.shopping.dao.User;
import com.shopping.service.AuthenticatorValidation;

/**
 * It controls the flow between view and service implementation 
 * for user table while authentication.
 * @author AswiniN
 *
 */
public class AuthenticationController {
    private static final AuthenticatorValidation AUTHENTICATOR_VALIDATION = new AuthenticatorValidation();
    /**
     * Validate EmailId.
     * @param emailId
     * @return
     */
    public boolean validateEmailId(final String emailId) {
	return AUTHENTICATOR_VALIDATION.validateEmailId(emailId);		
    }
    
    /**
     * Validate Password.
     * @param emailId
     * @param password
     * @return
     */
    public boolean validatePassword(final String emailId,final String password) {	
	return AUTHENTICATOR_VALIDATION.validtePassword(emailId, password);
    }
    
    /**
     * Insert user details.
     * @param user
     */
    public void insertData(User user) {
	AUTHENTICATOR_VALIDATION.insertData(user);	
    }
}
