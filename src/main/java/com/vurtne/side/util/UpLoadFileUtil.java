package com.vurtne.side.util;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class UpLoadFileUtil {
    /**
     * 获取上传后文件url地址
     * */
    public static String getUpLoadedFileUrl(String fileName) {
        String upLoadedFilePrefix = "https://vurtne-1252864727.cos.ap-shanghai.myqcloud.com/";
        return upLoadedFilePrefix + fileName;
    }

    /**
     *获取随机文件名称
     */
    public static String getRandomFileName(String ext) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        String nanoStr = String.valueOf(System.nanoTime());
        return uuidStr + "_" + nanoStr + ext;
    }
}
