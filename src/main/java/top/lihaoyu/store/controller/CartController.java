package top.lihaoyu.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lihaoyu.store.entity.Cart;
import top.lihaoyu.store.service.ICartService;
import top.lihaoyu.store.service.exception.InsertException;
import top.lihaoyu.store.utils.JsonResult;
import top.lihaoyu.store.vo.CartVo;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;


    @PostMapping("/addCart")
    public JsonResult<Void> addCart(Cart cart, HttpSession session){
        //从session中区域uid和用户名
        Integer uid = getUserIdFromSession(session);
        String username = getUsernameFromSession(session);
        cart.setUid(uid);
        Date date = new Date();
        int result = cartService.addCart(cart, username, date, username, date);

        if (result == 0){
            throw  new InsertException("服务器或数据库异常，加入购物车失败");
        }

        return new JsonResult<>(OK);
    }


    @GetMapping("/showCarts")
    public JsonResult<List<CartVo>> showCarts(HttpSession session){
        Integer uid = getUserIdFromSession(session);
        List<CartVo> carts = cartService.queryCartByUid(uid);

        return new JsonResult<>(OK,carts);
    }


    @PostMapping("/updateCart")
    public JsonResult<Void> updateCateByCid(Integer num,Integer cid,HttpSession session){
        String modifiedUser = getUsernameFromSession(session);
        Date modifiedTime = new Date();
        cartService.updateCartNumByCid(num,modifiedUser,modifiedTime,cid);
        return new JsonResult<>(OK);
    }


    @GetMapping("/queryCids")
    public JsonResult<List<CartVo>> queryCids(Integer[] cids){
        List<CartVo> list = cartService.queryCartByCids(cids);
        System.out.println(list.toString());
        if (list.size() == 0){
            return new JsonResult<>(9001);
        }
        return new JsonResult<>(OK,list);
    }


    @PostMapping("/deleteCart")
    public JsonResult<Void> deleteCartByCid(Integer[] cids){
        //遍历执行删除操作
        for (Integer cid: cids) {
            cartService.deleteCartByCid(cid);
        }

        return new JsonResult<>(OK);
    }

}
