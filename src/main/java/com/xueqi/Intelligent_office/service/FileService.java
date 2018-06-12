package com.xueqi.Intelligent_office.service;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    public String  fileUpload(MultipartFile file, HttpServletRequest request){

        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                logger.info("文件位置："+saveFile.getAbsolutePath());
                return saveFile.getAbsolutePath();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return saveFile.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
                return " file upload failure:" + e.getMessage();
            }
        } else {
            return "file upload failure,because the file is null";
        }

    }
}
