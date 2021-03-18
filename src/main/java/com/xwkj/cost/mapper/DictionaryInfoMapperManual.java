package com.xwkj.cost.mapper;

import com.xwkj.cost.model.DictionaryInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryInfoMapperManual {
    List<DictionaryInfo> getDictionaryInfoList(DictionaryInfo dictionaryInfo);
    List<DictionaryInfo> getList(DictionaryInfo dictionaryInfo);
}