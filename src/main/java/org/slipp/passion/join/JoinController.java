package org.slipp.passion.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {

    @RequestMapping(value="/join",method= RequestMethod.GET)
    public String joinpage(){

        return "join";
    }

}
