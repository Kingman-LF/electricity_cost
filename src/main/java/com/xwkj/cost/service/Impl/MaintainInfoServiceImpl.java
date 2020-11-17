package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.MaintainInfoMapperManual;
import com.xwkj.cost.mapper.auto.ContractInfoMapper;
import com.xwkj.cost.mapper.auto.MaintainInfoMapper;
import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.model.MaintainInfo;
import com.xwkj.cost.service.MaintainInfoService;
import com.xwkj.cost.util.DateUtil;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: electricity_cost
 * @description: 后期维护服务层
 * @author: 张永辉
 * @create: 2020-06-30 09:47
 **/
@Service
public class MaintainInfoServiceImpl implements MaintainInfoService {

    @Autowired
    private MaintainInfoMapper maintainInfoMapper;
    @Autowired
    private MaintainInfoMapperManual maintainInfoMapperManual;
    @Autowired
    private ContractInfoMapper contractInfoMapper;

    /**
     * @Description : 获取后期维护列表
     * @methodName : getMaintainInfoList
     * @param pageUtil :
     * @param maintainInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MaintainInfo>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public PageInfo<MaintainInfo> getMaintainInfoList(PageUtil pageUtil, MaintainInfo maintainInfo) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<MaintainInfo> maintainInfoList = maintainInfoMapperManual.getMaintainInfoList(maintainInfo);
        return new PageInfo<>(maintainInfoList);
    }

    /**
     * @Description : 添加后期维护信息
     * @methodName : addMaintainInfo
     * @param maintainInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void addMaintainInfo(MaintainInfo maintainInfo) {
        maintainInfo.setCreateTime(new Date());
        maintainInfoMapper.insertSelective(maintainInfo);
    }

    /**
     * @Description : 修改后期维护信息
     * @methodName : updateMaintainInfo
     * @param maintainInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void updateMaintainInfo(MaintainInfo maintainInfo) {
        maintainInfoMapper.updateByPrimaryKeySelective(maintainInfo);
    }

    /**
     * @Description : 删除后期维护信息
     * @methodName : deleteMaintainInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void deleteMaintainInfo(Long id) {
        MaintainInfo maintainInfo = new MaintainInfo();
        maintainInfo.setId(id).setStatus(0);
        maintainInfoMapper.updateByPrimaryKeySelective(maintainInfo);
    }

    /**
     * @Description : 批量删除后期维护信息
     * @methodName : batchDeleteMaintainInfo
     * @param ids :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void batchDeleteMaintainInfo(String ids) {
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            MaintainInfo maintainInfo = new MaintainInfo();
            maintainInfo.setId(Long.parseLong(split[i])).setStatus(0);
            maintainInfoMapper.updateByPrimaryKeySelective(maintainInfo);
        }
    }

    /**
     * @Description : 检查维护信息并在系统登录后提示未处理的超期或将要在30天内超期的维护信息
     * @methodName : checkMaintainInfo
     * @return : java.util.List<java.lang.String>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public List<String> checkMaintainInfo() {
        List<String> list = new ArrayList<>();
        //获取所有未处理的维护信息
        List<MaintainInfo> maintainInfos = maintainInfoMapperManual.getMaintainInfoListByCondition(new MaintainInfo().setStatus(1));
        //循环找出需要提醒的维护信息
        Date date = new Date();
        for (MaintainInfo maintainInfo : maintainInfos) {
            if (date.compareTo(maintainInfo.getEndTime()) == 1){
                ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(maintainInfo.getContractId());
                String s = contractInfo.getItemName() + "项目的维护名称：" + maintainInfo.getName() + "已过期，请尽快处理！";
                list.add(s);
            }else {
                if (DateUtil.getBetweenDay(date,maintainInfo.getEndTime()) < 30){
                    ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(maintainInfo.getContractId());
                    String s = contractInfo.getItemName() + "的维护名称：" + maintainInfo.getName() + "的期限已不足30天，请尽快处理！";
                    list.add(s);
                }
            }
        }
        return list;
    }
}
