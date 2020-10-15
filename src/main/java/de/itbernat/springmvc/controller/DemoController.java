package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.model.MetaInfo;
import de.itbernat.springmvc.service.DemoService;
import de.itbernat.springmvc.service.MetaInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Controller
public class DemoController
{
    private final DemoService demoService;
    private final MetaInfoService metaInfoService;


    @Autowired
    public DemoController(DemoService demoService, MetaInfoService metaInfoService)
    {
        this.demoService = demoService;
        this.metaInfoService = metaInfoService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model, @RequestParam Optional<String> user)
    {
        model.addAttribute("helloMessage", demoService.getHelloMessage(user.orElse("Dusan")));
        log.info("model: {}", model);
        return "main/welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage()
    {
        log.info("welcomeMessage() called");

        return demoService.getWelcomeMessage();
    }


    @ModelAttribute("meta")
    public MetaInfo metaInfo()
    {
        log.info("metaInfo() called");
        return metaInfoService.getMetaInfo();
    }


}