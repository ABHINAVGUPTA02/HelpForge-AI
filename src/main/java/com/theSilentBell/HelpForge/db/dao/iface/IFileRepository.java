package com.theSilentBell.HelpForge.db.dao.iface;

import com.theSilentBell.HelpForge.models.Bot;
import com.theSilentBell.HelpForge.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IFileRepository extends JpaRepository<File, UUID> {

    List<File> findByUserId(UUID userId);

}
