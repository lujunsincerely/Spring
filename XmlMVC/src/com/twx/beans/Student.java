package com.twx.beans;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by twx on 2017/3/19.
 */
public class Student {
    @NotNull
    @Min(0)
    @Max(100)
    private Integer age;
    @NotNull
    @Size(min = 3,max = 15)
    private String name;
    @NotNull
    private Integer id;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
