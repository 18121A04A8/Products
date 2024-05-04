package com.Ecommers.Products.Controller;

import com.Ecommers.Products.Dto.InstructorDto;
import com.Ecommers.Products.Dto.UserDto;
import com.Ecommers.Products.Models.Instructor;
import com.Ecommers.Products.Models.User;
import com.Ecommers.Products.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }

    @PostMapping("")
    public User creatUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto.getName(), userDto.getEmailId());
    }

    @GetMapping("/{name}")
    public List<User> getByName(@PathVariable(name = "name") String name){
        return userService.getByName(name);
    }

    @PostMapping("/Instructor")
    public Instructor createInstructor(@RequestBody InstructorDto instructorDto){
        return userService.saveInstructor(instructorDto);
    }

    @GetMapping("/Instructor/{name}")
    public List<InstructorDto> getInstructorByName(@PathVariable(name = "name") String name){
        return userService.getInstructorByName(name);
    }








}
