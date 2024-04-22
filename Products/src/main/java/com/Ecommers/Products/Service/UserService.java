package com.Ecommers.Products.Service;

import com.Ecommers.Products.Dto.InstructorDto;
import com.Ecommers.Products.Models.Instructor;
import com.Ecommers.Products.Models.User;
import com.Ecommers.Products.Repository.InstructorRepository;
import com.Ecommers.Products.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private InstructorRepository instructorRepository;
    public UserService(UserRepository userRepository, InstructorRepository instructorRepository){

        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
    }


    public User saveUser(String name, String emailId) {
        User user = new User();
        user.setName(name);
        user.setEmail(emailId);
        userRepository.save(user);
        return user;
    }


    public List<User> getByName(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.findByName(name);

    }

    public Instructor saveInstructor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();
        instructor.setSalary(instructorDto.getSalary());
        instructor.setBatch(instructorDto.getBatch());
        instructor.setName(instructorDto.getName());
        instructorRepository.save(instructor);
        return instructor;
    }

    public Instructor getInstructorByName(String name) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        return instructorRepository.findByName(name).get();

    }


}
