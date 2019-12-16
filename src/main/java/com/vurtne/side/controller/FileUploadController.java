package com.vurtne.side.controller;

import com.qcloud.cos.model.PutObjectResult;
import com.vurtne.side.annotation.PassToken;
import com.vurtne.side.model.VResponse;
import com.vurtne.side.service.FileService;
import com.vurtne.side.util.UpLoadFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @Resource
    private FileService fileService;

    @GetMapping("/upLoadFile")
    @PassToken
    public String index() {
        return "index";
    }

    @PostMapping("/upLoadFile")
    @PassToken
    @ResponseBody
    public VResponse<String> fileUpLoad(HttpServletRequest request,@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return VResponse.Error("file is empty");
        }

        String originalFilename = file.getOriginalFilename();

        int extIndex = originalFilename.lastIndexOf(".");

        String ext = extIndex == -1 ? "" : originalFilename.substring(extIndex);

        String filename = UpLoadFileUtil.getRandomFileName(ext);

        String classpath = ResourceUtils.getURL("classpath:").getPath();

        File tempDic = new File(classpath + "/temp");

        if (!tempDic.exists()) {
            tempDic.mkdirs();
        }

        File localFile = new File(tempDic.getAbsolutePath(), filename);

        if (!localFile.exists()) {
            localFile.createNewFile();
        }

        file.transferTo(localFile);
        PutObjectResult result = fileService.upLoadFileToOss(filename, localFile);

        if (result == null) {
            VResponse.Error("上传文件失败！");
        }


        if (localFile.exists()){
            localFile.delete();
        }


        return VResponse.OK(UpLoadFileUtil.getUpLoadedFileUrl(filename));
    }
}
