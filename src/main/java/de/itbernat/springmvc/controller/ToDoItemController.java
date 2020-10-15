package de.itbernat.springmvc.controller;

import de.itbernat.springmvc.model.ToDoItem;
import de.itbernat.springmvc.model.ToDoItemsWrapper;
import de.itbernat.springmvc.service.ToDoDataService;
import de.itbernat.springmvc.utils.AttributeNames;
import de.itbernat.springmvc.utils.Mappings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(Mappings.TODO_ITEM_ITEMS_PATH)
    public String getItems(@ModelAttribute(AttributeNames.ITEMS_MODEL_ATTRIBUTE) ToDoItemsWrapper itemsWrapper)
    {
        itemsWrapper.setItems(toDoDataService.getItems());
        return Mappings.TODO_ITEM_ITEMS_VIEW;
    }

    @GetMapping(Mappings.TODO_ITEM_ADD_ITEM_PATH)
    public String addItem(@RequestParam(required = false, defaultValue = "-1") int id, @ModelAttribute(AttributeNames.ITEM_MODEL_ATTRIBUTE) ToDoItem toDoItem)
    {
        log.info(toDoItem.toString());
        if (id > 0)
        {
            ToDoItem item = toDoDataService.getItem(id);
            toDoItem.setTitle(item.getTitle());
            toDoItem.setDetails(item.getDetails());
            toDoItem.setDeadline(item.getDeadline());
        }
        return Mappings.TODO_ITEM_ADD_ITEM_VIEW;
    }

    @PostMapping(Mappings.TODO_ITEM_ADD_ITEM_PATH)
    public String addItem(@ModelAttribute(AttributeNames.ITEM_MODEL_ATTRIBUTE) ToDoItem toDoItem, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            log.error(bindingResult.toString());
            return "redirect:" + Mappings.TODO_ITEM_ITEMS_PATH;
        }

        if (toDoItem.getId() == 0)
        {
            toDoDataService.addItem(toDoItem);
        }
        else
        {
            toDoDataService.updateItem(toDoItem);
        }
        return "redirect:" + Mappings.TODO_ITEM_ITEMS_PATH;
    }

    @GetMapping(Mappings.TODO_ITEM_REMOVE_ITEM_PATH)
    public String removeItem(@RequestParam int id)
    {
        toDoDataService.removeItem(id);
        return "redirect:" + Mappings.TODO_ITEM_ITEMS_PATH;
    }

    @InitBinder(AttributeNames.ITEM_MODEL_ATTRIBUTE)
    public void initBinder(WebDataBinder dataBinder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
