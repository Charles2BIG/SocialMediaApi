package com.socialmedia.api;

public record UserRequest(
    String userName,
    String userEmail,
    String password) {
}
