package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ReturnTicketInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnTicketInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReturnTicketInfo record);

    int insertSelective(ReturnTicketInfo record);

    ReturnTicketInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReturnTicketInfo record);

    int updateByPrimaryKey(ReturnTicketInfo record);
}