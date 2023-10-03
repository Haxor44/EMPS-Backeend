package com.crud.crudApi.services;

import com.crud.crudApi.model.User;
import com.crud.crudApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUSer(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(User user, int id){
        return userRepository.findById(id)
                .map(users -> {
                    users.setName(user.getName());
                    users.setEmail(user.getEmail());
                    users.setLocation(user.getLocation());
                    return userRepository.save(user);
                });
    }

    public String deleteUser(int id){
        if (!userRepository.existsById(id)){
            return "User not found!!!";
        }
        userRepository.deleteById(id);
        return "User deleted successfully!!!";
    }
}
