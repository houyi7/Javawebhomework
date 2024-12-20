package top.lihaoyu.store.mapper;

import top.lihaoyu.store.entity.District;

import java.util.List;


public interface DistrictMapper {

    //根据父代号查询区域信息
    List<District> queryDistrictByParent(String parent);

    //根据code查询当前省市区的名称
    String queryDistrictByCode(String code);
}
