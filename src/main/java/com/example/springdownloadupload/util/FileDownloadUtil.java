package com.example.springdownloadupload.util;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileDownloadUtil {
    private Path foundFile;

    public Resource getFileAsResources(String filecode) throws IOException {
        Path uploadDirector = Paths.get("Files-Uploads");
        Files.list(uploadDirector).forEach(file ->{
            if(file.getFileName().toString().startsWith(filecode))
                foundFile = file;
            return;
        });
        if (Objects.nonNull(foundFile)){
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}
