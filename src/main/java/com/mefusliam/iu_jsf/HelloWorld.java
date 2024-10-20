package com.mefusliam.iu_jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class HelloWorld implements Serializable {
    private String name = "What up?";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
