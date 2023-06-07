package com.socialmedia.api;

import java.util.Optional;

public interface IUserRepository {

    Optional<User> getUserById(int userId);

}
