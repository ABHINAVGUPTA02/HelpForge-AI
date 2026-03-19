package com.theSilentBell.HelpForge.services;

import com.theSilentBell.HelpForge.db.dao.iface.IFileRepository;
import com.theSilentBell.HelpForge.models.FileMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private IFileRepository fileRepository;

    public boolean uploadFile(MultipartFile file) {
        try {
            // create directory
            String pwd = System.getProperty("user.dir");
            java.io.File dir = new java.io.File(pwd + "/uploads/");
            if(!dir.exists()){
                dir.mkdirs();
            }

            // get metadata for file
            String fileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename();
            String filePath = pwd + "/uploads/" +  file.getOriginalFilename();
            java.io.File dest = new java.io.File(filePath);

            // transfer the file to the disk
            file.transferTo(dest);

            // create the file instance
            FileMetaData fileMetaData = new FileMetaData(fileName,  filePath);

            // save it db
            fileRepository.save(fileMetaData);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }
}
