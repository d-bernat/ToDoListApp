package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class MainController
{
    @GetMapping("/welcome")
    public String welcome(@ModelAttribute("user") User user)
    {
        if(user.getName() == null && user.getSurName() == null  && user.getAddress() == null)
        {
            user.setName("Dusan");
            user.setSurName("Bernat");
            user.setAddress("Bekstr. 11, 22880 Wedel");
        }
        return "main/welcome";
    }
}
