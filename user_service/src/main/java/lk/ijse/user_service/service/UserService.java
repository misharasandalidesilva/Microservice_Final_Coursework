package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.ResponseDTO;
import lk.ijse.user_service.dto.UserDTO;

import java.util.List;

public interface UserService {
    ResponseDTO registerUser(UserDTO userDTO);

    UserDTO loginUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}

