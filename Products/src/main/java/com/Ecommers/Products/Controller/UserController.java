package com.Ecommers.Products.Controller;

import com.Ecommers.Products.Dto.UserDto;
import com.Ecommers.Products.Models.User;
import com.Ecommers.Products.Service.UserService;
import org.springframework.web.bind.annotation.*;

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
    public User getByName(@PathVariable(name = "name") String name){
        return userService.getByName(name);
    }




}
