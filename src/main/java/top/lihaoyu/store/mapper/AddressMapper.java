package top.lihaoyu.store.mapper;

import top.lihaoyu.store.entity.Address;

import java.util.Date;
import java.util.List;

public interface AddressMapper {


    int addAddress(Address address);


    int userAddressCount(Integer uid);


    List<Address> queryUserAddress(Integer uid);


    Address queryUserAddressByAid(Integer aid);


    int setAllAddressNotDefault(Integer uid);


    int setOneAddressDefault(Integer aid,String modifiedUser, Date modifiedTime);


    int deleteAddressByAid(Integer aid,String modifiedUser, Date modifiedTime);


    int updateUserAddressByAid(Address address);

}
