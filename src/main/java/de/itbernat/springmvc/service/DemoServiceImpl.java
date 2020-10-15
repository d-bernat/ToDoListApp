package de.itbernat.springmvc.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements  DemoService
{
    @Override
    public String getHelloMessage(String user)
    {
        return justForAopTest(user);
    }

    @Override
    public String getWelcomeMessage()
    {
        return "Welcome to this demo application";
    }

    private String justForAopTest(String user)
    {
        return "Hello (AOP) " + user;
    }
}
