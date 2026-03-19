package com.theSilentBell.HelpForge.db.dao.iface;

import com.theSilentBell.HelpForge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IAuthRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
