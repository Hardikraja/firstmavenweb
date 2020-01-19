package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    DbHelper dbHelper = new DbHelper();
    @RequestMapping("/")
    public String initPage(){
        return "main-page";
    }

    @RequestMapping("/reg-page")
    public String getRegPage(Model theModel){
        theModel.addAttribute("user",new UserBean());
        return "registration_page";
    }

    @RequestMapping("/login-page")
    public String loginPage(){
        return "login_page";
    }

    @RequestMapping(value="/show_user")
    public String checkUser(@RequestParam("username")String user, @RequestParam("password")String password, Model theModel,HttpSession session) throws Exception{
        if(!dbHelper.validateUser(user,password)){
            return "User_not_avail";
        }
        else {
            UserBean userBeanObj = dbHelper.getUserDetail(user, password);
            theModel.addAttribute("selecteduser", userBeanObj);
            theModel.addAttribute("imageString",ImageGetSet.showImageBytes(userBeanObj.getImagepath(),session));
            return "show-data";
        }
    }

    @RequestMapping("/processForm")
    public String insertData(@RequestParam("profilepic") CommonsMultipartFile file, @ModelAttribute("userbean") UserBean theUser, HttpSession session) throws Exception{
        String dob = theUser.getDob();
        String userName = theUser.getUsername();
        String email = theUser.getEmail();
        String password = theUser.getPassword();
        String path = ImageGetSet.setImageToRepo(file,session);
        dbHelper.InsertData(userName,email,password,dob,path);
        return "login_page";
    }
}
