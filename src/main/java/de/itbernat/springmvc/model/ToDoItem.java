package de.itbernat.springmvc.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@Data
@EqualsAndHashCode(of = "id")
public class ToDoItem
{
    private int id;
    private String title;
    private String details;
    private Date deadline;

    public ToDoItem(String title, String details, Date deadline)
    {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}
