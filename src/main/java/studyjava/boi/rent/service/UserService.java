package studyjava.boi.rent.service;

import studyjava.boi.rent.dto.UserDto;
import studyjava.boi.rent.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
