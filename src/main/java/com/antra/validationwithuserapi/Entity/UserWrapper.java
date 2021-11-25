package com.antra.validationwithuserapi.Entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserWrapper {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private Support support;
}
