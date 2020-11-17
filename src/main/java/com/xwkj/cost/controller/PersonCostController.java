package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.PersonCost;
import com.xwkj.cost.service.PersonCostService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: electricity_cost
 * @description: 人员成本控制层
 * @author: 张永辉
 * @create: 2020-06-29 10:20
 **/
@RestController
@Slf4j
public class PersonCostController {

    @Autowired
    private PersonCostService personCostService;


    /**
     * @Description : 获取人员成本列表
     * @methodName : getPersonCostList
     * @param pageUtil :
     * @param personCost :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getPersonCostList")
    public ResponseResult getPersonCostList(PageUtil pageUtil, PersonCost personCost){
        ResponseResult responseResult = null;
        try {
            PageInfo<PersonCost> list = personCostService.getPersonCostList(pageUtil, personCost);
            log.info("获取人员成本列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取人员成本列表成功");
        } catch(Exception e){
            log.error("获取人员成本列表失败",e);
            responseResult = ResponseResult.failure("获取人员成本列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加人员成本信息
     * @methodName : addPersonCost
     * @param personCost :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addPersonCost")
    public ResponseResult addPersonCost(PersonCost personCost){
        ResponseResult responseResult = null;
        try {
            personCostService.addPersonCost(personCost);
            log.info("添加人员成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加人员成本信息成功");
        } catch(Exception e){
            log.error("添加人员成本信息失败",e);
            responseResult = ResponseResult.failure("添加人员成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改人员成本信息
     * @methodName : updatePersonCost
     * @param personCost :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updatePersonCost")
    public ResponseResult updatePersonCost(PersonCost personCost){
        ResponseResult responseResult = null;
        try {
            personCostService.updatePersonCost(personCost);
            log.info("修改人员成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改人员成本信息成功");
        } catch(Exception e){
            log.error("修改人员成本信息失败",e);
            responseResult = ResponseResult.failure("修改人员成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除人员成本信息
     * @methodName : deletePersonCost
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deletePersonCost/{id}")
    public ResponseResult deletePersonCost(@PathVariable("id") Long id){
        ResponseResult responseResult = null;
        try {
            personCostService.deletePersonCost(id);
            log.info("删除人员成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除人员成本信息成功");
        } catch(Exception e){
            log.error("删除人员成本信息失败",e);
            responseResult = ResponseResult.failure("删除人员成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 批量删除人员成本信息
     * @methodName : batchDeletePersonCost
     * @param ids :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/batchDeletePersonCost/{ids}")
    public ResponseResult batchDeletePersonCost(@PathVariable("ids") String ids){
        ResponseResult responseResult = null;
        try {
            personCostService.batchDeletePersonCost(ids);
            log.info("批量删除人员成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"批量删除人员成本信息成功");
        } catch(Exception e){
            log.error("批量删除人员成本信息失败",e);
            responseResult = ResponseResult.failure("批量删除人员成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 根据主键获取人员成本信息
     * @methodName : getPersonCostById
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getPersonCostById/{id}")
    public ResponseResult getPersonCostById(@PathVariable("id") Long id){
        ResponseResult responseResult = null;
        try {
            PersonCost personCost = personCostService.getPersonCostById(id);
            log.info("根据主键获取人员成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),personCost,"根据主键获取人员成本信息成功");
        } catch(Exception e){
            log.error("根据主键获取人员成本信息失败",e);
            responseResult = ResponseResult.failure("根据主键获取人员成本信息失败");
        }
        return responseResult;
    }

}
