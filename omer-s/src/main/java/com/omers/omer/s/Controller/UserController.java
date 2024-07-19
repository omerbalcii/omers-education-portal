package com.omers.omer.s.Controller;

import com.omers.omer.s.Model.User;
import com.omers.omer.s.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8081/user/getall
    @GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //findByUsername
    //http://localhost:8081/user/getbyusername/{username}
    @GetMapping(path = "/getbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getByUserName(@PathVariable(name = "username") String username) {
        try {
            List<User> users = userService.findByUsername(username);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/user/getbyid/{id}
    @GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@PathVariable(name = "id") Integer id) {
        try {
            Optional<User> user = userService.getById(id);
            return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //findByEmail
    //http://localhost:8081/user/getbyemail/{email}
    @GetMapping(path = "/getbyemail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getByEmail(@PathVariable(name = "email") String email) {
        try {
            List<User> users = userService.findByEmail(email);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/user/save
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/user/delete/{id}
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        try {
            boolean result = userService.deleteUser(id);
            if (result) {
                return ResponseEntity.ok(id + " id'li kullanıcı başarı ile silindi");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id'li kullanıcı bulunamadı");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(id + " id'li kullanıcı silinemedi");
        }
    }
}
