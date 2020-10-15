package de.itbernat.springmvc.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ToDoItemsWrapper
{
    private List<ToDoItem> items = new ArrayList<>();
}
