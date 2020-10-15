package de.itbernat.springmvc.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ToDoData
{
    private static int idValue = 1;
    private static final List<ToDoItem> items = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        addItem( new ToDoItem("first", "first details", Date.from(Instant.now())));
        addItem( new ToDoItem("second", "second details", Date.from(Instant.now())));
        addItem( new ToDoItem("third", "third details", Date.from(Instant.now())));
        log.info(items.stream().map( item -> item.toString()).collect(Collectors.joining(";")));
    }

    public List<ToDoItem> getItems()
    {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull ToDoItem toAdd)
    {
        toAdd.setId(idValue++);
        items.add(toAdd);
    }

    public void removeItem(final int id)
    {
        items.removeAll(items.stream().filter(item -> item.getId() == id).collect(Collectors.toList()));
    }

    public ToDoItem getItem(final int id)
    {
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext())
        {
            ToDoItem item =itemIterator.next();
            if(item.getId() == id)
            {
                return item;
            }
        }

        return null;
    }

    public void updateItem(@NonNull ToDoItem toUpdate)
    {
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext())
        {
            ToDoItem item =itemIterator.next();
            if(item.equals(toUpdate))
            {
                itemIterator.set(toUpdate);
                break;
            }
        }
    }

}
