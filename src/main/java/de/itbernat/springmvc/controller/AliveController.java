package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.service.AliveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AliveController
{

    private final AliveService aliveService;

    @Autowired
    public AliveController(AliveService aliveService)
    {
        this.aliveService = aliveService;
    }



    // http://localahost:8080/ToDoListApp/monitoring/alive
    @GetMapping("/monitoring/alive")
    public String alive()
    {
        return aliveService.getTime();
    }
}
