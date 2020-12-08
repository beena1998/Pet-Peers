package com.service;

import com.model.User;

public interface SecurityService {
public abstract String authenticateUser(User user);
}
