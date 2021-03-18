package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.DictionaryInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

/**
 * @program: electricity_cost
 * @description:
 * @author: 张永辉
 * @create: 2021-03-16 16:45
 **/
public interface DictionaryInfoService {

    void addDictionary(DictionaryInfo dictionaryInfo);

    void updateDictionary(DictionaryInfo dictionaryInfo);

    void deleteDictionary(Long id);

    PageInfo<DictionaryInfo> getDictionaryInfoList(DictionaryInfo dictionaryInfo, PageUtil pageUtil);

    List<DictionaryInfo> getList(DictionaryInfo dictionaryInfo);

}
