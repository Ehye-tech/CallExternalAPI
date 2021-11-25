package com.antra.validationwithuserapi.Entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
public class Info {

    private String userName;
    private String password;
}
