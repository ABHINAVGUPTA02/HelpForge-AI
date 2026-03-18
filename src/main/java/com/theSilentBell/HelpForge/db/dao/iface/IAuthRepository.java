package com.theSilentBell.HelpForge.db.dao.iface;

import com.theSilentBell.HelpForge.models.User;

import java.util.Optional;

public interface IAuthRepository {

    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    void save(User user);
}
