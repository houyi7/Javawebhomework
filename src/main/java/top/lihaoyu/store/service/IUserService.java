package top.lihaoyu.store.service;

import top.lihaoyu.store.entity.User;

import javax.servlet.http.HttpSession;


public interface IUserService {

    //处理用户注册
    void userRegister(User user);

    //处理用户登录
    User userLogin(User user);

    //处理用户修改密码
    void userResetPwd(String oldPwd,String newPwd,HttpSession session);

    //处理用户修改个人资料
    void userUpdateInfo(String phone,String email,Integer gender,String username,Integer uid);

    //根据id查询用户信息
    User queryUserByUid(Integer uid);

    //处理用户上传图片
    void userUploadImg(String imgAddress,Integer uid);
}
