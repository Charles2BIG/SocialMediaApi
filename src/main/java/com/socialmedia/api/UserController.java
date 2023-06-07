package com.socialmedia.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId:\\d+}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertUser(@RequestBody UserRequest userRequest) {
        userService.insertUser(
                userRequest.userName(),
                userRequest.userEmail(),
                userRequest.password()
        );
    }
}
