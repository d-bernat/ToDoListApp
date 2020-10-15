package de.itbernat.springmvc.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("User")
public class User
{
    private int id;
    private String name;
    private String surname;
    private String address;
}
