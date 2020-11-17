package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.SubEnclosureInfoMapperManual;
import com.xwkj.cost.mapper.auto.SubEnclosureInfoMapper;
import com.xwkj.cost.model.SubEnclosureInfo;
import com.xwkj.cost.service.SubEnclosureInfoService;
import com.xwkj.cost.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SubEnclosureInfoServiceImpl implements SubEnclosureInfoService {

    @Autowired
    SubEnclosureInfoMapper subEnclosureInfoMapper;
    @Autowired
    SubEnclosureInfoMapperManual subEnclosureInfoMapperManual;
    @Value("${subcontract.filepath}")
    private String FILE_PATH;

    /**
     * @Description : 上传成本合同附件
     * @methodName : uploadSubEnclosureInfo
     * @param file :
     * @param id :
     * @return : java.lang.String
     * @exception :
     * @author : zyh
     */
    @Override
    public String uploadSubEnclosureInfo(MultipartFile file,Long id) throws IOException {
        Date date = new Date();
        if (!file.isEmpty()){
            String fileName = DateUtil.dateToString(date,DateUtil.YYYYMMDDHHMMSS)+UUID.randomUUID().toString().substring(0,5);
            // 获得文件类型
            String fileType = file.getContentType();
            // 获得文件后缀名称
            String originalFilename = file.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String ext = originalFilename.substring(i+1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String basedir = sdf.format(date);
            //文件名称
            fileName = FILE_PATH+"/" + fileName + "." + ext;
            File filePath = new File(FILE_PATH);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            //上传文件
            file.transferTo(new File(fileName));
            return fileName + ",";
        }
        return "";
    }

    /**
     * @Description : 根据成本合同主键获取成本合同的附件列表
     * @methodName : getSubEnclosureInfoBySubContractId
     * @param subContractId :
     * @return : java.util.List<com.xwkj.cost.model.SubEnclosureInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<SubEnclosureInfo> getSubEnclosureInfoBySubContractId(Long subContractId) {
        return subEnclosureInfoMapperManual.getSubEnclosureInfoBySubContractId(subContractId);
    }
}

