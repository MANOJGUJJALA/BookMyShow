package controller;


import dto.UserRequestDto;
import dto.UserResponseDto;
import modals.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserResponseDto signup(UserRequestDto userRequestDto){

            UserResponseDto responseDto=new UserResponseDto();
        try{

            User user=userService.signUp(userRequestDto.getName(),userRequestDto.getEmail(),userRequestDto.getPassword());

            responseDto.setId(user.getId());
            responseDto.setName(user.getName());
            responseDto.setEmail(user.getName());

            responseDto.setResponseCode(200);
            responseDto.setResponseMessage("SUCCES");

            return  responseDto;
        }
        catch (Exception e){

            responseDto.setResponseCode(500);
            responseDto.setResponseMessage("Internal Server Error");
            return responseDto;

        }


    }

}
