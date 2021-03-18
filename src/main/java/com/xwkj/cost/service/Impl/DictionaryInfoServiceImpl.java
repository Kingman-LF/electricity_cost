package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.DictionaryInfoMapperManual;
import com.xwkj.cost.mapper.auto.DictionaryInfoMapper;
import com.xwkj.cost.model.DictionaryInfo;
import com.xwkj.cost.service.DictionaryInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: electricity_cost
 * @description:
 * @author: 张永辉
 * @create: 2021-03-16 16:46
 **/
@Service
public class DictionaryInfoServiceImpl implements DictionaryInfoService {

    @Autowired
    private DictionaryInfoMapper dictionaryInfoMapper;
    @Autowired
    private DictionaryInfoMapperManual dictionaryInfoMapperManual;


    @Override
    public void addDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryInfo.setDicStatus(1);
        dictionaryInfoMapper.insertSelective(dictionaryInfo);
    }

    @Override
    public void updateDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryInfoMapper.updateByPrimaryKeySelective(dictionaryInfo);
    }

    @Override
    public void deleteDictionary(Long id) {
        DictionaryInfo dictionaryInfo = new DictionaryInfo();
        dictionaryInfo.setId(id).setDicStatus(0);
        dictionaryInfoMapper.updateByPrimaryKeySelective(dictionaryInfo);
    }

    @Override
    public PageInfo<DictionaryInfo> getDictionaryInfoList(DictionaryInfo dictionaryInfo, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
        List<DictionaryInfo> dictionaryInfoList = dictionaryInfoMapperManual.getDictionaryInfoList(dictionaryInfo);
        return new PageInfo<>(dictionaryInfoList);
    }

    @Override
    public List<DictionaryInfo> getList(DictionaryInfo dictionaryInfo) {
        return dictionaryInfoMapperManual.getList(dictionaryInfo);
    }
}
