package sda.serviceaggregatingevents.utils;

import sda.serviceaggregatingevents.DTO.UserResponse;
import sda.serviceaggregatingevents.entity.User;

public class Convertor {
    public static UserResponse convertEntityToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        String[] name = user.getName().split(" ");
        userResponse.setName(name[0]);
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole().getName());
        return userResponse;
    }
}
