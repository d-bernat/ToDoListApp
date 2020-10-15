package de.itbernat.springmvc.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequestScope
@Getter
public class AliveService
{
    private final String time = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date());
}
