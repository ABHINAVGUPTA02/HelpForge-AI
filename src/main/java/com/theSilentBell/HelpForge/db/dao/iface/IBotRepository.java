package com.theSilentBell.HelpForge.db.dao.iface;

import com.theSilentBell.HelpForge.models.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBotRepository extends JpaRepository<Bot, UUID> {

    Optional<Bot> findByBotname(String botName);
    List<Bot> findByUserUsername(String username);
}
