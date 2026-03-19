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

    private String fileName;

    private String filePath;

    public FileMetaData(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ",fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
