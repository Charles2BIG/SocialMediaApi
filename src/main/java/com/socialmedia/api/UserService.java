package com.socialmedia.api;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String userName, String userEmail, String password) {

    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public void insertUser(String userName, String userEmail, String password) {
        userRepository.insertUser(userName, userEmail, password);
    }
}
