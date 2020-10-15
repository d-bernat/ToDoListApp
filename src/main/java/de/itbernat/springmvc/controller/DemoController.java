package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.model.MetaInfo;
import de.itbernat.springmvc.service.DemoService;
import de.itbernat.springmvc.service.MetaInfoService;
import de.itbernat.springmvc.utils.AttributeNames;
import de.itbernat.springmvc.utils.Mappings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(Mappings.WELCOME_PATH)
    public String welcome(Model model, @RequestParam(required = false, defaultValue = "Dusan") String user)
    {
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        log.info("model: {}", model);
        return Mappings.WELCOME_VIEW;
    }

    @ModelAttribute(AttributeNames.WELCOME_MESSAGE_MODEL_ATTRIBUTE)
    public String welcomeMessage()
    {
        log.info("welcomeMessage() called");

        return demoService.getWelcomeMessage();
    }


    @ModelAttribute(AttributeNames.META_INFO_MODEL_ATTRIBUTE)
    public MetaInfo metaInfo()
    {
        log.info("metaInfo() called");
        return metaInfoService.getMetaInfo();
    }


}
