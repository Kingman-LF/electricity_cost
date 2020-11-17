package com.xwkj.cost.service;

import com.xwkj.cost.model.SubEnclosureInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SubEnclosureInfoService {

    /**
     * @Description : 上传成本合同附件
     * @methodName : uploadSubEnclosureInfo
     * @param file :
     * @param id :
     * @return : java.lang.String
     * @exception :
     * @author : zyh
     */
    String uploadSubEnclosureInfo(MultipartFile file,Long id) throws IOException;

    /**
     * @Description : 根据成本合同主键获取成本合同的附件列表
     * @methodName : getSubEnclosureInfoBySubContractId
     * @param subContractId :
     * @return : java.util.List<com.xwkj.cost.model.SubEnclosureInfo>
     * @exception :
     * @author : zyh
     */
    List<SubEnclosureInfo> getSubEnclosureInfoBySubContractId(Long subContractId);

}
