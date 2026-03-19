package com.theSilentBell.HelpForge.services;

import com.theSilentBell.HelpForge.db.dao.iface.IBotRepository;
import com.theSilentBell.HelpForge.db.dao.iface.IFileRepository;
import com.theSilentBell.HelpForge.models.Bot;
import com.theSilentBell.HelpForge.models.FileMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BotService {

    @Autowired
    private IBotRepository botRepository;

    @Autowired
    private IFileRepository fileRepository;

    public Boolean createBot(Bot bot) {
        if(botRepository.findByBotname(bot.getBotname()).isPresent()) {
            return false;
        }

        botRepository.save(bot);
        return true;
    }

    public Boolean getBot(String botname) {
        if(botRepository.findByBotname(botname).isPresent()) {
            return true;
        }
        return false;
    }

    public List<Bot> getBots(String username) {
        List<Bot> bots = botRepository.findByUserUsername(username);
        if (!bots.isEmpty()) {
            return bots;
        }
        return null;
    }


    public Boolean deleteBot(String botname){
        if(botRepository.findByBotname(botname).isPresent()) {
            botRepository.delete(botRepository.findByBotname(botname).get());
            return true;
        }

        return false;
    }

    public List<FileMetaData> getFiles(String botname) {
        if (botRepository.findByBotname(botname).isPresent()) {
            return fileRepository.findByBotBotname(botname);
        }

        return null;
    }
}
