package de.itbernat.springmvc.service;

import de.itbernat.springmvc.model.ToDoData;
import de.itbernat.springmvc.model.ToDoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoDataService
{
    private final ToDoData toDoData;

    @Autowired
    public ToDoDataService(ToDoData toDoData)
    {
        this.toDoData = toDoData;
    }

    public List<ToDoItem> getItems()
    {
        return toDoData.getItems();
    }

    public void addItem(ToDoItem toDoItem)
    {
        toDoData.addItem(toDoItem);
    }

}
