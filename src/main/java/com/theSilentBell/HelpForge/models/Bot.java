package com.theSilentBell.HelpForge.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="bots")
@Getter
@Setter
public class Bot {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID botId;

    private String botname;

    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy="bot",  cascade=CascadeType.ALL)
    private List<FileMetaData> filesMetaData;

    Bot(String botname, String description) {
        this.botname = botname;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "botId=" + botId +
                ", botName='" + botname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

