package org.slipp.passion.imsi;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Slf4j
public class HelloController {

    @Autowired
    HelloService helloService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(@RequestParam(required = false,defaultValue = "Slipp") String name, ModelMap model) {
        log.debug("hello");
		model.addAttribute("message", helloService.greetingMessage(name));
		return "hello";
	}
	
	@RequestMapping("/hasun")
	public String 간다하선(Model model){
		model.addAttribute("message","축하합니다.");
		return "hasun";
	}
}