package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.RecordInfoMapperManual;
import com.xwkj.cost.mapper.auto.DictionaryInfoMapper;
import com.xwkj.cost.mapper.auto.RecordInfoMapper;
import com.xwkj.cost.model.DictionaryInfo;
import com.xwkj.cost.model.RecordInfo;
import com.xwkj.cost.service.RecordInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: electricity_cost
 * @description:
 * @author: 张永辉
 * @create: 2021-03-16 17:09
 **/
@Service
public class RecordInfoServiceImpl implements RecordInfoService {

    @Autowired
    private RecordInfoMapper recordInfoMapper;
    @Autowired
    private RecordInfoMapperManual recordInfoMapperManual;
    @Autowired
    private DictionaryInfoMapper dictionaryInfoMapper;

    @Override
    public void addRecordInfo(RecordInfo recordInfo) {
        recordInfoMapper.insertSelective(recordInfo.setCreateTime(new Date()).setIsEnable(1));
    }

    @Override
    public void updateRecordInfo(RecordInfo recordInfo) {
        recordInfoMapper.updateByPrimaryKeySelective(recordInfo);
    }

    @Override
    public void deleteRecordInfo(Long id) {
        RecordInfo recordInfo = new RecordInfo();
        recordInfo.setId(id).setIsEnable(0);
        recordInfoMapper.updateByPrimaryKeySelective(recordInfo);
    }

    @Override
    public PageInfo<RecordInfo> getRecordInfoList(RecordInfo recordInfo, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        List<RecordInfo> recordInfoList = recordInfoMapperManual.getRecordInfoList(recordInfo);
        recordInfoList.forEach(r -> {
            DictionaryInfo name = dictionaryInfoMapper.selectByPrimaryKey(r.getName());
            DictionaryInfo unit = dictionaryInfoMapper.selectByPrimaryKey(r.getUnit());
            r.setNameStr(name.getDicName()).setUnitName(unit.getDicName());
        });
        return new PageInfo<>(recordInfoList);
    }
}
