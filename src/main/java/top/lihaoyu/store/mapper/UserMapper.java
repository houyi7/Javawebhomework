package top.lihaoyu.store.mapper;

import org.apache.ibatis.annotations.Param;
import top.lihaoyu.store.entity.User;
import java.util.Date;


public interface UserMapper {


    int addUser(User user);


    User queryUserByUsername(String username);


    int updatePassword(String password,
                       String modifiedUser,
                       Date modifiedTime,
                       String username);



    User queryUserByUid(Integer uid);


    int UpdateUserInfo(String phone,
                       String email,
                       Integer gender,
                       String modifiedUser,
                       Date modifiedTime,
                       Integer uid);

    int updateUserAvatar(@Param("file") String ImgAddress,
                         String modifiedUser,
                         Date modifiedTime,
                         Integer uid);


}
