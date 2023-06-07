package com.socialmedia.api;

public interface IUserService {

    void createUser(String userName, String userEmail, String password);

    User getUserById(int userId);
}
