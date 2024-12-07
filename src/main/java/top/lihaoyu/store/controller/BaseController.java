package top.lihaoyu.store.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import top.lihaoyu.store.controller.exception.*;
import top.lihaoyu.store.service.exception.*;
import top.lihaoyu.store.utils.JsonResult;
import javax.servlet.http.HttpSession;


public class BaseController {
    //操作成功的状态码
    public static final int OK = 200;


    @ExceptionHandler({ServiceException.class,FileUploadException.class,ValidCodeNotMatchException.class}) //统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicateException){
            result.setStatus(4000); //表示用户名重复
        }else if (e instanceof InsertException){
            result.setStatus(5001); //数据库或服务器有问题
        }else if (e instanceof UserNotExistException){
            result.setStatus(5002); //表示用户数据不存在
        }else if (e instanceof WrongPasswordException){
            result.setStatus(5003); //表示密码错误
        }else if (e instanceof OriginalPasswordNotMatchException){
            result.setStatus(5004); //表示原密码错误
        }else if (e instanceof FileEmptyException){
            result.setStatus(6000); //表示上传文件为空错误
        }else if (e instanceof FileSizeException){
            result.setStatus(6001); //表示上传文件超过限制错误
        }else if (e instanceof FileStatusException){
            result.setStatus(6002); //表示上传文件状态异常错误
        }else if (e instanceof FileTypeNotMatchException){
            result.setStatus(6003); //表示上传文件类型不符错误
        }else if (e instanceof FileUploadIOException){
            result.setStatus(6004); //表示上传文件IO读取错误
        }else if (e instanceof AddressCountLimitException){
            result.setStatus(7000); //表示地址数量已超限制
        }else if (e instanceof AddressNotExistsException){
            result.setStatus(7001); //表示地址不存在
        }else if (e instanceof DeleteException){
            result.setStatus(7002); //表示服务器或数据地址删除失败
        }else if (e instanceof ProductNotExistsException){
            result.setStatus(8000); //表示商品不存在
        }else if (e instanceof ProductBadStatusException){
            result.setStatus(8001); //表示商品状态异常
        }else if (e instanceof UpdateException){
            result.setStatus(9000); //表示数据更新失败
        }else if (e instanceof CartInfoNotExistsException){
            result.setStatus(9001); //表示查询的cart数据不存在
        }else if (e instanceof OrderNotExistsException){
            result.setStatus(3000); //表示查询的order数据不存在
        }else if (e instanceof ValidCodeNotMatchException){
            result.setStatus(1001); //表示验证码错误
        }
        //返回异常处理结果
        return result;
    }

    /**
     * Description : 从session中获取用户uid
     * @date 2022/7/11
     * @param session springboot启动时生成的session对象
     * @return java.lang.Integer
     **/
    public final Integer getUserIdFromSession(HttpSession session){
        String uidStr = session.getAttribute("uid").toString();

        return Integer.valueOf(uidStr);
    }


    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
