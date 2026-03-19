package com.theSilentBell.HelpForge.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="files")
@Getter
@Setter
public class FileMetaData {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID fileId;

    private String filename;

    private String filePath;

    @ManyToOne
    @JoinColumn(name="bot_id")
    private Bot bot;

    public FileMetaData(String filename, String filePath) {
        this.filename = filename;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ",fileName='" + filename + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
