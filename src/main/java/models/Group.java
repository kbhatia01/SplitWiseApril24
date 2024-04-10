package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "userGroup")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List <User> members;
    @OneToMany
    private List <Expense> expenses;

    @ManyToOne
    private User createdBy;
}

// Group  1 : M   Expense
