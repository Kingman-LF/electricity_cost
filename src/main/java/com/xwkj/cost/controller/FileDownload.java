package com.xwkj.cost.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Description:TODO 文件下载
 * @Author wanglei
 * @Create 2019-12-12 13:39
 * @Version 1.0
 */
@RestController
@Slf4j
public class FileDownload {

	@GetMapping("fileDownload")
	public void fileDownload(@RequestParam("filePath") String filePath, HttpServletResponse response) throws UnsupportedEncodingException {
		// 如果文件名不为空，则进行下载
		if (filePath != null) {
			File file = new File(filePath);
			// 如果文件存在，则进行下载
			if (file.exists()) {
				//下载文件名字
				String filename = filePath.substring(filePath.lastIndexOf("/")+1);
				// 配置文件下载
				response.setHeader("content-type", "application/octet-stream");
				response.setContentType("application/octet-stream");
				// 下载文件能正常显示中文
				response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("Download  successfully!");
				} catch (Exception e) {
					System.out.println("Download  failed!");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
