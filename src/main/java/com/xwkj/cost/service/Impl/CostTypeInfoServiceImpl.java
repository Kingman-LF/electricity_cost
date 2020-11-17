package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.ContractCostTypeRelatedMapperManual;
import com.xwkj.cost.mapper.CostTypeInfoMapperManual;
import com.xwkj.cost.mapper.PersonCostMapperManual;
import com.xwkj.cost.mapper.SubContractInfoMapperManual;
import com.xwkj.cost.mapper.auto.CostTypeInfoMapper;
import com.xwkj.cost.model.ContractCostTypeRelated;
import com.xwkj.cost.model.CostTypeInfo;
import com.xwkj.cost.model.PersonCost;
import com.xwkj.cost.model.SubContractInfo;
import com.xwkj.cost.service.CostTypeInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CostTypeInfoServiceImpl implements CostTypeInfoService{

    @Autowired
    private CostTypeInfoMapper costTypeInfoMapper;
    @Autowired
    private CostTypeInfoMapperManual costTypeInfoMapperManual;
    @Autowired
    private SubContractInfoMapperManual subContractInfoMapperManual;
    @Autowired
    private ContractCostTypeRelatedMapperManual contractCostTypeRelatedMapperManual;
    @Autowired
    private PersonCostMapperManual personCostMapperManual;

    /**
     * @Description : 获取成本分类列表
     * @methodName : getCostTypeInfoList
     * @return : java.util.List<com.xwkj.cost.model.CostTypeInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<CostTypeInfo> getCostTypeInfoList() {
        return costTypeInfoMapperManual.getCostTypeInfoList();
    }

    /**
     * @Description : 增加成本分类信息
     * @methodName : addCostTypeInfo
     * @param costTypeInfo :
     * @return : java.lang.Long
     * @exception :
     * @author : zyh
     */
    @Override
    public Long addCostTypeInfo(CostTypeInfo costTypeInfo) {
        costTypeInfoMapper.insertSelective(costTypeInfo);
        return costTypeInfo.getId();
    }

    /**
     * @Description : 修改成本分类信息
     * @methodName : updateCostTypeInfo
     * @param costTypeInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void updateCostTypeInfo(CostTypeInfo costTypeInfo) {
        costTypeInfoMapper.updateByPrimaryKeySelective(costTypeInfo);
    }

    /**
     * @Description : 删除成本分类信息
     * @methodName : deleteCostTypeInfo
     * @param ids :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteCostTypeInfo(String ids) {
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            CostTypeInfo costTypeInfo = new CostTypeInfo();
            costTypeInfo.setId(Long.parseLong(split[i])).setIsEnable(0);
            costTypeInfoMapper.updateByPrimaryKeySelective(costTypeInfo);
        }
    }

    /**
     * @Description : 根据合同主键获取成本类型树
     * @methodName : getCostTypeInfoListByContractId
     * @param contractId :
     * @return : java.util.List<com.xwkj.cost.model.CostTypeInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<CostTypeInfo> getCostTypeInfoListByContractId(Long contractId) {
        //根据合同主键获取所有其他成本信息
        List<ContractCostTypeRelated> otherCostList = contractCostTypeRelatedMapperManual.getContractCostTypeRelatedListByContractId(new ContractCostTypeRelated().setContractId(contractId));
        //根据合同主键获取成本合同信息
        List<SubContractInfo> subContractInfoList = subContractInfoMapperManual.getSubContractInfoListByContractId(new SubContractInfo().setContractId(contractId));
        //根据合同主键获取人员成本信息
//        List<PersonCost> personCostList = personCostMapperManual.getPersonCostList(new PersonCost().setContractId(contractId));


        //存储成本类型主键的Set
        Set<Long> costTypeIds = new HashSet<>();
        //将其他成本中的成本类型放入Set中
        if (otherCostList != null){
            for (ContractCostTypeRelated c : otherCostList){
                String costTypeId = c.getCostTypeId();
                String[] split = costTypeId.split(",");
                for (int i = 0; i < split.length; i++) {
                    costTypeIds.add(Long.parseLong(split[i]));
                }
            }
        }
        //将成本合同中的成本类型放入Set中
        if (subContractInfoList != null ){
            for (SubContractInfo s : subContractInfoList){
                String costTypeId = s.getCostTypeId();
                String[] split = costTypeId.split(",");
                for (int i = 0; i < split.length; i++) {
                    costTypeIds.add(Long.parseLong(split[i]));
                }
            }
        }
        //将人员成本的成本类型放入Set中
        /*if (personCostList != null){
            for (PersonCost p : personCostList) {
                String costTypeId = p.getCostTypeId();
                String[] split = costTypeId.split(",");
                for (int i = 0; i < split.length; i++) {
                    costTypeIds.add(Long.parseLong(split[i]));
                }
            }
        }*/

        if (costTypeIds.size() == 0){
            return null;
        }
        List<Long> costTypeIdList = new ArrayList<>(costTypeIds);
        String ids = StringUtils.join(costTypeIdList, ",");
        List<CostTypeInfo> list = costTypeInfoMapperManual.getCostTypeInfoListByIds(ids);
        return list;
    }
}
