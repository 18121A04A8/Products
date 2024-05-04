package com.Ecommers.Products.Service;

import com.Ecommers.Products.Dto.InstructorDto;
import com.Ecommers.Products.Models.Batch;
import com.Ecommers.Products.Models.Instructor;
import com.Ecommers.Products.Models.User;
import com.Ecommers.Products.Repository.InstructorRepository;
import com.Ecommers.Products.Repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        instructor.setName(instructorDto.getName());

        instructorRepository.save(instructor);
        return instructor;
    }

    public List<InstructorDto> getInstructorByName(String name) {

        List<Instructor> instructors = instructorRepository.findByName(name);
        List<InstructorDto> instructorDto = new ArrayList<>();
        for(Instructor instructor : instructors){
            InstructorDto instructorDto1 = new InstructorDto();
            instructorDto1.setId(instructor.getId());
            instructorDto1.setName(instructor.getName());
            instructorDto1.setSalary(instructor.getSalary());

            List<String> batchNames = new ArrayList<>();
            List<UUID> batchIds = new ArrayList<>();
            for(Batch batch : instructor.getBatch()){
                batchNames.add(batch.getName());
                batchIds.add(batch.getId());
            }
            instructorDto1.setBatchName(batchNames);

            instructorDto.add(instructorDto1);
        }
        return instructorDto;

    }

}
