package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.model.User;
import de.itbernat.springmvc.utils.AttributeNames;
import de.itbernat.springmvc.utils.Mappings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class MainController
{
    @GetMapping(Mappings.MAIN_ADD_USER_PATH)
    public String welcome(@ModelAttribute(AttributeNames.USER_MODEL_ATTRIBUTE) User user)
    {
        if(user.getName() == null && user.getSurname() == null  && user.getAddress() == null)
        {
            user.setName("Dusan");
            user.setSurname("Bernat");
            user.setAddress("Bekstr. 11, 22880 Wedel");
        }
        return Mappings.MAIN_ADD_USER_VIEW;
    }
}
