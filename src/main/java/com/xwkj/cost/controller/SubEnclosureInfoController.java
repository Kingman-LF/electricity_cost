package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.SubEnclosureInfo;
import com.xwkj.cost.service.SubEnclosureInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
public class SubEnclosureInfoController {

    @Autowired
    SubEnclosureInfoService subEnclosureInfoService;

    /**
     * @Description : 上传成本合同附件
     * @methodName : uploadSubEnclosureInfo
     * @param file :
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PostMapping("/uploadSubEnclosureInfo")
    public ResponseResult uploadSubEnclosureInfo(MultipartFile file,Long id){
        ResponseResult responseResult = null;
        try {
            String path = subEnclosureInfoService.uploadSubEnclosureInfo(file, id);
            if (!"".equals(path)){
                log.info("上传成本合同附件成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),path,"上传成本合同附件成功");
            }else {
                log.error("成本合同附件为空");
                responseResult = ResponseResult.failure("成本合同附件为空");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("上传成本合同附件失败");
            responseResult = ResponseResult.failure("上传成本合同附件失败");
        }
        return responseResult;
    }

    /**
     * @Description : 根据成本合同主键获取成本合同的附件列表
     * @methodName : getSubEnclosureInfoListBySubContractId
     * @param subContractId :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("getSubEnclosureInfoListBySubContractId/{subContractId}")
    public ResponseResult getSubEnclosureInfoListBySubContractId(@PathVariable Long subContractId){
        ResponseResult responseResult = null;
        try {
            List<SubEnclosureInfo> list = subEnclosureInfoService.getSubEnclosureInfoBySubContractId(subContractId);
            log.info("获取成本合同的附件列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取成本合同的附件列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("根据成本合同主键获取成本合同的附件列表失败");
            responseResult = ResponseResult.failure("根据成本合同主键获取成本合同的附件列表失败");
        }
        return responseResult;
    }

}
