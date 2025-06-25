package lk.ijse.user_service.controller;

import lk.ijse.user_service.dto.ResponseDTO;
import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.registerUser(userDTO));

    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody UserDTO userDTO) {
        UserDTO userdto = userService.loginUser(userDTO);
        if (userdto != null) {
            return ResponseEntity.ok(new ResponseDTO("success", userdto));
        } else {
            return ResponseEntity.badRequest().body(new ResponseDTO("error", "Invalid username or password"));
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}

