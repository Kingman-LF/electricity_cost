package com.xwkj.cost.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.DictionaryInfo;
import com.xwkj.cost.service.DictionaryInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.List;

/**
 * @program: electricity_cost
 * @description:
 * @author: 张永辉
 * @create: 2021-03-16 16:44
 **/
@RestController
@Slf4j
public class DictionaryInfoController {
    @Autowired
    private DictionaryInfoService dictionaryInfoService;

    /**
     * @Description : 获取数据字典列表信息
     * @methodName : getDictionaryList
     * @param dictionaryInfo :
     * @param pageUtil :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getDictionaryList")
    public ResponseResult getDictionaryList(DictionaryInfo dictionaryInfo, PageUtil pageUtil){
        ResponseResult responseResult = null;
        try {
            PageInfo<DictionaryInfo> dictionaryInfoList = dictionaryInfoService.getDictionaryInfoList(dictionaryInfo, pageUtil);
            log.info("获取数据字典列表信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),dictionaryInfoList,"获取数据字典列表信息成功！");
        } catch(Exception e){
            log.error("获取数据字典列表信息失败！",e);
            responseResult = ResponseResult.failure("获取数据字典列表信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 添加数据字典信息
     * @methodName : addDictionary
     * @param dictionaryInfo :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addDictionary")
    public ResponseResult addDictionary(DictionaryInfo dictionaryInfo) {
        ResponseResult responseResult = null;
        try {
            dictionaryInfoService.addDictionary(dictionaryInfo);
            log.info("添加数据字典成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加成功！");
        } catch(Exception e){
            log.error("添加数据字典失败！",e);
            responseResult = ResponseResult.failure("添加失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 修改数据字典信息
     * @methodName : updateDictionary
     * @param dictionary :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updateDictionary")
    public ResponseResult updateDictionary(DictionaryInfo dictionaryInfo) {
        ResponseResult responseResult = null;
        try {
            dictionaryInfoService.updateDictionary(dictionaryInfo);
            log.info("修改数据字典成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改成功！");
        } catch(Exception e){
            log.error("修改数据字典失败！",e);
            responseResult = ResponseResult.failure("修改失败！");
        }
        return responseResult;
    }


    /**
     * @Description : 删除数据字典信息
     * @methodName : deleteDictionary
     * @param id :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deleteDictionary/{id}")
    public ResponseResult deleteDictionary(@PathVariable("id") Long id){
        ResponseResult responseResult = null;
        try {
            dictionaryInfoService.deleteDictionary(id);
            log.info("删除数据字典成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除成功！");
        } catch(Exception e){
            log.error("删除数据字典失败！",e);
            responseResult = ResponseResult.failure("删除失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 获取数据字典下拉菜单列表
     * @methodName : getDicList
     * @param parentId :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getDicList/{parentId}")
    public ResponseResult getDicList(@PathVariable("parentId") Long parentId){
        ResponseResult responseResult = null;
        try {
            List<DictionaryInfo> list = dictionaryInfoService.getList(new DictionaryInfo().setDicParentid(parentId).setDicStatus(1));
            log.info("获取数据字典下拉菜单列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取数据字典下拉菜单列表成功");
        } catch(Exception e){
            log.error("获取数据字典下拉菜单列表失败！",e);
            responseResult = ResponseResult.failure("获取数据字典下拉菜单列表失败！");
        }
        return responseResult;
    }

}
