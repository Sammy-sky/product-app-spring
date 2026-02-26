package com.proyectofinal.product_app.controllers;

import com.proyectofinal.product_app.model.LoginRequest;
import com.proyectofinal.product_app.services.UserService;
import com.proyectofinal.product_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    // Soluciona el aviso de la línea 32
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") @NonNull Integer id){
        return userService.getUser(id);
    }

    // Soluciona el aviso de la línea 37
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody() @NonNull User user, @PathVariable("id") Long id){
        return userService.updateUser(user);
    }

    // Soluciona el aviso de la línea 42
    @PostMapping("/register")
    public ResponseEntity<User> newUser(@RequestBody() @NonNull User user){
        User newUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // Soluciona el aviso de la línea 48
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") @NonNull Integer id){
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) { // ✅ sin HttpSession
        try {
            boolean isAuthenticated = userService.authenticate(
                loginRequest.getUsername(), loginRequest.getPassword()
            );
            if (isAuthenticated) {
                return ResponseEntity.ok("Login was successful!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Nombre de usuario o contraseña no válidos");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Se ha producido un error desconocido.");
        }
    }
}