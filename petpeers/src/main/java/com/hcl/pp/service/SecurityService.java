package com.hcl.pp.service;

import com.hcl.pp.model.User;

public interface SecurityService {
public abstract boolean authenticateUser(String username, String userPassword);
public abstract User authenticateUser1(int userid);
}
