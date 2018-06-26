package com.mall.common;

import com.mall.utils.ResponseTemplate;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UploadAction extends ActionSupport {

    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;

    public Map<String, Object> jsonResult;

    public String upload() {
        if (uploadFile == null) {
            jsonResult = ResponseTemplate.error(-1, "No file!");
            return SUCCESS;
        }

        // 1.获取文件的保存路径
        String basePath = ServletActionContext.getServletContext().getRealPath("/uploads");
        File basePathFile = new File(basePath);
        if (!basePathFile.exists()) {
            basePathFile.mkdirs();
        }

        // 2.把文件名UUID
        String GUIDFileName = TokenHelper.generateGUID();
        if ("image/png".equals(uploadFileContentType)) {
             GUIDFileName = GUIDFileName + ".png";
        } else {
            GUIDFileName = GUIDFileName + ".jpg";
        }

        // 3.保存文件
        // 复制：临时文件还在，浪费服务器磁盘空间
        //FileUtils.copyFile(visitFile, new File(file,GUIDFileName));
        // 剪切：把临时文件重命名到指定位置（比较好）
        uploadFile.renameTo(new File(basePathFile, GUIDFileName));

        // 4. 返回结果，将文件的保存路径返回
        Map<String, Object> map = new HashMap<>();
        map.put("filePath", "uploads/" + GUIDFileName);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

}
