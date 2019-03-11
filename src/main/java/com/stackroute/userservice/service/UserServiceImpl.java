package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user){
        User savedUser=userRepository.save(user);
        return savedUser;
    }

    public List<User> getAllUsers(){
        List<User> allUsers = (List)userRepository.findAll();
        return allUsers;
    }

    public User getUserById(int id){
        Optional<User>  user=  userRepository.findById(id);
        return user.get();
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public User updateUser(int id,User user){
        User findUser = userRepository.findById(id).get();
        findUser.setAge(user.getAge());
        return userRepository.save(findUser);
    }
}
