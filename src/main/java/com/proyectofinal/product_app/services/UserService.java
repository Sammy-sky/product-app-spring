package com.proyectofinal.product_app.services;

import com.proyectofinal.product_app.model.User;
import com.proyectofinal.product_app.repositories.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull; // Importación obligatoria para los avisos

import java.util.List;

@Service
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    // CORRECCIÓN 1: Constructor limpio con una sola inyección
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // Soluciona el aviso de la línea 29
    public User getUser(@NonNull Integer id){
        return userRepository.findById(id).orElse(null);
    }

    // Lo agregamos por seguridad, aunque el IDE no te haya gritado aquí
    public User addUser(@NonNull User user){
        // Aquí se encripta y se guarda en el campo Password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Soluciona el aviso de la línea 39
    public User updateUser(@NonNull User user) {
        return userRepository.save(user);
    }

    // Soluciona el aviso de la línea 43
    public void deleteUser(@NonNull Integer id){
        userRepository.deleteById(id);
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user == null || !user.getUsername().equals(username)){
            throw new UsernameNotFoundException("El usuario no existe en la base de datos.");
        }

        // CORRECCIÓN 2: Comparamos contra getPassword(), que es donde guardamos el texto encriptado
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("La contraseña es incorrecta.");
        }

        return true;
    }
}