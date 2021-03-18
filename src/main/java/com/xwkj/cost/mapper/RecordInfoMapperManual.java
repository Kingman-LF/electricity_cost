package com.xwkj.cost.mapper;

import com.xwkj.cost.model.RecordInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordInfoMapperManual {
    List<RecordInfo> getRecordInfoList(RecordInfo recordInfo);
}