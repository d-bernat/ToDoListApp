package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.model.ToDoItem;
import de.itbernat.springmvc.model.ToDoItemsWrapper;
import de.itbernat.springmvc.service.ToDoDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ToDoItemController
{
    private final ToDoDataService toDoDataService;

    @Autowired
    public ToDoItemController(ToDoDataService toDoDataService)
    {
        this.toDoDataService = toDoDataService;
    }

    @GetMapping("/items")
    public String getItems(@ModelAttribute("itemsWrapper") ToDoItemsWrapper itemsWrapper)
    {
        itemsWrapper.setItems(toDoDataService.getItems());
        return "main/items";
    }

    @GetMapping("/additem")
    public String editItem(@ModelAttribute("item") ToDoItem toDoItem)
    {
        return "main/additem";
    }

    @PostMapping("/additem")
    public String addItem(@ModelAttribute("item") ToDoItem toDoItem, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "redirect:/items";
        }
        toDoDataService.addItem(toDoItem);
        return "redirect:/items";
    }

    @InitBinder("item")
    public void initBinder(WebDataBinder dataBinder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
