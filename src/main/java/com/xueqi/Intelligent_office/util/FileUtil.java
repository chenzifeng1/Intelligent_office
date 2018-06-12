package com.xueqi.Intelligent_office.util;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {
    private static final String filePath = "D:\\2018\\img\\";
    public static void uploadFile(byte[] file,  String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
