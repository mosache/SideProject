package com.vurtne.side.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class User {
    private Long id;

    private String username;

    private String password;

    private Long create_time;
}
