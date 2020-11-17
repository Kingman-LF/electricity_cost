package com.xwkj.cost.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:TODO 多文件上传接口
 * @Author wanglei
 * @Create 2019-12-10 17:19
 * @Version 1.0
 */
public interface FileUploadsService {

	/***
	 * @description: 多文件上传接口
	 * @methodName: fileUploads
	 * @param: [file]
	 * @return: java.lang.String
	 * @exception:
	 * @date:  2019-12-10 17:20
	 * @author: wanglei
	 */
	String fileUploads(MultipartFile file);
}
