package de.itbernat.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AliveController
{
    // http://localahost:8080/ToDoListApp/monitoring/alive
    @ResponseBody
    @GetMapping("/monitoring/alive")
    public String alive()
    {
        return "OK";
    }
}
