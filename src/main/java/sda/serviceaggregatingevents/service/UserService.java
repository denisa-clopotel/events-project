package sda.serviceaggregatingevents.service;


import sda.serviceaggregatingevents.DTO.RegisterRequest;
import sda.serviceaggregatingevents.DTO.UserResponse;
import sda.serviceaggregatingevents.entity.User;


import java.util.List;


public interface UserService {
    void saveUser(RegisterRequest userDto);

    void saveAdmin(RegisterRequest userDto);

    UserResponse getUser(Long id);

    User findByEmail(String email);

    List<UserResponse> findAllUsers();

    void deleteUser(Long id);
}




