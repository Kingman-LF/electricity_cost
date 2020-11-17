package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ReturnTicketInfo;
import com.xwkj.cost.service.ReturnTicketInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ReturnTicketInfoController {

    @Autowired
    ReturnTicketInfoService returnTicketInfoService;

    /**
     * @Description : 根据成本合同主键获取回票信息列表
     * @methodName : getReturnTicketInfoList
     * @param pageUtil : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @GetMapping("/getReturnTicketInfoList")
    public ResponseResult getReturnTicketInfoList(PageUtil pageUtil,Long id){
        ResponseResult responseResult = null;
        try {
            PageInfo<ReturnTicketInfo> list = returnTicketInfoService.getReturnTicketInfoList(pageUtil,id);
            log.info("获取回票信息列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取回票信息列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取回票信息列表失败");
            responseResult = ResponseResult.failure("获取回票信息列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加回票信息
     * @methodName : addReturnTicketInfo
     * @param returnTicketInfo : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PostMapping("/addReturnTicketInfo")
    public ResponseResult addReturnTicketInfo(ReturnTicketInfo returnTicketInfo) {
        ResponseResult responseResult = null;
        try {
            returnTicketInfoService.addReturnTicketInfo(returnTicketInfo);
            log.info("添加回票信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加回票信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加回票信息失败");
            responseResult = ResponseResult.failure("添加回票信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改回票信息
     * @methodName : updateReturnTicketInfo
     * @param returnTicketInfo : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PutMapping("/updateReturnTicketInfo")
    public ResponseResult updateReturnTicketInfo(ReturnTicketInfo returnTicketInfo) {
        ResponseResult responseResult = null;
        try {
            returnTicketInfoService.updateReturnTicketInfo(returnTicketInfo);
            log.info("修改回票信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改回票信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改回票信息失败");
            responseResult = ResponseResult.failure("修改回票信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除回票信息
     * @methodName : deleteReturnTicketInfo
     * @param id : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @DeleteMapping("/deleteReturnTicketInfo/{id}")
    public ResponseResult deleteReturnTicketInfo(@PathVariable Long id) {
        ResponseResult responseResult = null;
        try {
            returnTicketInfoService.deleteReturnTicketInfo(id);
            log.info("删除回票信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除回票信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除回票信息失败");
            responseResult = ResponseResult.failure("删除回票信息失败");
        }
        return responseResult;
    }
}
