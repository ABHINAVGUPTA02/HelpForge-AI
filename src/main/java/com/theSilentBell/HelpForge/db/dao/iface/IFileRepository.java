package com.theSilentBell.HelpForge.db.dao.iface;

import com.theSilentBell.HelpForge.models.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IFileRepository extends JpaRepository<FileMetaData, UUID> {

    Optional<FileMetaData> findByFilename(String filename);
    List<FileMetaData> findByBotBotname(String botname);
}
