package lk.ijse.user_service.service.impl;

import lk.ijse.user_service.dto.ResponseDTO;
import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;
import lk.ijse.user_service.repo.UserRepository;
import lk.ijse.user_service.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseDTO registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return new ResponseDTO("error", "Email already exists");
        }

        User user = modelMapper.map(userDTO, User.class);

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        userRepository.save(user);

        return new ResponseDTO("success", "User registered successfully");
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            UserDTO userdto = modelMapper.map(userRepository.findByEmail(userDTO.getEmail()), UserDTO.class);
            if(userDTO.getPassword().equals(userdto.getPassword())) {
                return userdto;
            }
        } else {
            return null;
        }
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            return Collections.emptyList();
        }

        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }
}
