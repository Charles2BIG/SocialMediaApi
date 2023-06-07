package com.socialmedia.api;

public record User(
        int id,
        String userName,
        String userEmail,
        String password
) {

}
