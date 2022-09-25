package com.example.springdownloadupload.controllers;

import com.example.springdownloadupload.upload.FileUploadResponse;
import com.example.springdownloadupload.util.FileUploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/uploadfile")
    public ResponseEntity<FileUploadResponse> fileUploadResponseResponse(
            @RequestParam("file")MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownload("/downloadFile/" + fileCode);

        return new ResponseEntity<FileUploadResponse>(response, HttpStatus.OK);
    }

}
