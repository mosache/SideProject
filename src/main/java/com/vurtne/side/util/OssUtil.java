package com.vurtne.side.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

/**
 * 腾讯云存储
 * */
@Component
public class OssUtil {

    @Value("${tx-oss.app-id}")
    private String APP_ID;

    @Value("${tx-oss.secret-id}")
    private String SECRET_ID;

    @Value("${tx-oss.secret-key}")
    private String SECRET_KEY;

    private COSClient client;

    /**
     * 初始化客户端
     * */
    public boolean initOss() {
        try {
            BasicCOSCredentials basicCOSCredentials = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);

            Region region = new Region("ap-shanghai");

            ClientConfig clientConfig = new ClientConfig(region);

            client = new COSClient(basicCOSCredentials,clientConfig);

        }catch (Exception ex){
            return false;
        }
        return true;
    }

    /**
     * 创建bucket
     *
     * */
    public Bucket createNewBucket(String bucketName, CannedAccessControlList authority) throws Exception{
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);

        createBucketRequest.setCannedAcl(authority);

        try {
            Bucket bucketResult = client.createBucket(createBucketRequest);
            return bucketResult;
        }catch (CosServiceException serverException){
            throw serverException;
        }catch (CosClientException clientException){
            throw clientException;
        }
    }

    /**
     * 小文件上传， <= 5GB , 一般 20M 以内
     * */
    public PutObjectResult simpleUpLoad(String bucketName,String objectKey,File file) throws Exception {
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectKey, file);
            PutObjectResult putObjectResult = client.putObject(putObjectRequest);
            return putObjectResult;
        }catch (Exception ex){
            throw ex;
        }
    }

    /**
     * 获取文件下载地址
     * */
    public String getObject(String bucketName,String objectKey) throws Exception {
        try {
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey, HttpMethodName.GET);
            URL fileUrl = client.generatePresignedUrl(generatePresignedUrlRequest);
            return fileUrl.toString();
        }catch (Exception ex){
            throw ex;
        }
    }

    /**
     * 关闭client
     * */
    public void shutDown() {
        client.shutdown();
    }






}
