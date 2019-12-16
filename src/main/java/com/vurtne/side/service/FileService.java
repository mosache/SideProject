package com.vurtne.side.service;

import com.qcloud.cos.model.PutObjectResult;
import com.vurtne.side.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

@Service
public class FileService {

    @Resource
    private OssUtil ossUtil;

    @Value("${tx-oss.bucket-name}")
    private String bucketName;

    /**
     * 文件上传
     * */
    public PutObjectResult upLoadFileToOss(String objectKey, File file){
        try {
            return ossUtil.simpleUpLoad(bucketName,objectKey,file);
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败！");
        }
    }
}
