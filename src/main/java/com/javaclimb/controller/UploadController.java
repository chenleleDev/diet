package com.javaclimb.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaclimb.util.ReturnData;
import com.javaclimb.util.UUIDUtil;
import com.javaclimb.util.UploadUtils;

/**
 * 上传图片
 *
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
	
	/**
	 * 上传图片
	 * 某个图片.a.jpg
	 */
	@RequestMapping(value="/uploadImg",method= {RequestMethod.POST})
	public ReturnData uploadImg(@PathVariable(value="file")MultipartFile file,HttpServletRequest request) {
		//获取原始文件名
		String str = file.getOriginalFilename();
		//生成一个唯一的文件名
		String name = UUIDUtil.getUUID()+str.substring(str.lastIndexOf("."));
		//生成一个文件夹
		String dir = UploadUtils.getDir(name);
		//物理地址文件夹路径
		String path_dir = request.getSession().getServletContext().getRealPath("/upload")+dir+"/";

		try {
			//判断是不是已经有了这个文件夹，如果没有，创建它
			File newFile_dir = new File(path_dir);
			if(!newFile_dir.exists()) {
				newFile_dir.mkdirs();
			}
			String path_full = path_dir+name;
			file.transferTo(new File(path_full));
		} catch (IllegalStateException | IOException e) {			
			e.printStackTrace();
			return ReturnData.fail("上传失败");
		}
			
		return ReturnData.success("upload"+dir+"/"+name);
		
	}

}
