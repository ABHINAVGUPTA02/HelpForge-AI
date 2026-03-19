package com.theSilentBell.HelpForge.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID userId;

    private String username;

    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Bot> bots;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
