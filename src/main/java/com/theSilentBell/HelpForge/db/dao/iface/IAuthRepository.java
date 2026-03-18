package com.theSilentBell.HelpForge.db.dao.iface;

import com.theSilentBell.HelpForge.models.User;

public interface IAuthRepository {

    public Boolean createUser(User user) throws Exception;
}
