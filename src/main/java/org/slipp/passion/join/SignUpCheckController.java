package org.slipp.passion.join;

import static org.slipp.passion.join.SignUpCheckController.CheckedMassage.fail;
import static org.slipp.passion.join.SignUpCheckController.CheckedMassage.success;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import javax.servlet.http.HttpServletResponse;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpCheckController {

    @Autowired
    SignUpChecker signupChecker;

    @RequestMapping(value="/signup_check/username",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public CheckedMassage checkname(@RequestParam String value, HttpServletResponse response){
        if(signupChecker.isReservedUsername(value)){
            response.setStatus(FORBIDDEN.value());
            return fail("Username is a reserved word.");
        }

        if(signupChecker.isDuplicatedUsername(value)){
            response.setStatus(FORBIDDEN.value());
            return fail("Username is already taken.");
        }

        return success();
    }


    @RequestMapping(value="/signup_check/email",method=RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public CheckedMassage checkemail(@RequestParam String value, HttpServletResponse response){
        if(signupChecker.isReservedEmail(value)){
            response.setStatus(FORBIDDEN.value());
            return fail("Email is a reserved word.");
        }

        if(signupChecker.isDuplicatedEmail(value)){
            response.setStatus(FORBIDDEN.value());
            return fail("Email is already taken.");
        }

        return success();
    }

    @RequestMapping(value="/signup_check/password",method=RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public CheckedMassage checkepassword(@RequestParam String value, HttpServletResponse response){
        if(false == signupChecker.isValidPassword(value)){
            response.setStatus(FORBIDDEN.value());
            return fail("Password is not valid");
        }

        return success();
    }

    public static class CheckedMassage {
        @Getter
        boolean success=false;
        @Getter String text="";

        CheckedMassage(boolean success, String text) {
            this.success = success;
            this.text = text;
        }

        static CheckedMassage success(){
            return new CheckedMassage(true,"");
        }

        static CheckedMassage fail(String text){
            return new CheckedMassage(false,text);
        }
    }
}
