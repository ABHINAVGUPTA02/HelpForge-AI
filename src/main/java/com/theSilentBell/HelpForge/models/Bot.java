package com.theSilentBell.HelpForge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;

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

    private String botName;

    private String description;

    Bot(String botName, String description) {
        this.botName = botName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "botId=" + botId +
                ", botName='" + botName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

