package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.service.FileUploadsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Description:TODO 多文件上传
 * @Author wanglei
 * @Create 2019-12-10 17:16
 * @Version 1.0
 */
@RestController
@Slf4j
public class FileUploadsController {

	@Autowired
	FileUploadsService fileUploadsService;

	@PostMapping("/uploads")
	public ResponseResult fileUploads(MultipartFile file){
		ResponseResult responseResult = null;
		try {
			String filePaths = fileUploadsService.fileUploads(file);
			responseResult = ResponseResult.success(0,filePaths,"多文件上传成功!");
			log.info("多文件上传成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("多文件上传失败！");
			responseResult = ResponseResult.failure(1,"多文件上传失败!");
		}
		return responseResult;
	}
}
