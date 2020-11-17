package com.xwkj.cost.service.Impl;

import com.xwkj.cost.service.FileUploadsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2019-12-10 17:20
 * @Version 1.0
 */
@Service
public class FileUploadsServiceImpl implements FileUploadsService {

	@Value("${UPLOAD_FILE_PATH}")
	private String UPLOAD_FILE_PATH;
	/***
	 * @description: 多文件上传接口实现
	 * @methodName: fileUploads
	 * @param: [file]
	 * @return: java.lang.String
	 * @exception:
	 * @date: 2019-12-10 17:20
	 * @author: wanglei
	 * @param file
	 */
	@Override
	public String fileUploads(MultipartFile file) {
		String fileUpload = null;
		if (!file.isEmpty()) {
			try {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				// 获得文件类型
				String fileType = file.getContentType();
				// 获得文件后缀名称
				String ext = fileType.substring(fileType.indexOf("/") + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String basedir = sdf.format(new Date());
				//文件名称
				fileUpload = UPLOAD_FILE_PATH+"/" + basedir + "/" + uuid + "." + ext;
				File uploadFile = new File(fileUpload);
				if (!uploadFile.exists()) {
					uploadFile.mkdirs();
				}
				//上传文件
				file.transferTo(uploadFile);
				fileUpload = fileUpload.concat(",");
			} catch (IOException e) {
				return "";
			}
			return fileUpload;
		} else {
			return null;
		}
	}
}
