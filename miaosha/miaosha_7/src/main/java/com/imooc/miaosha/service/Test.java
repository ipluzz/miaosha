package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.MiaoshaUserDao;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    private  MiaoshaUser getById(long id){
        return miaoshaUserDao.getById(id);
    }
    public static void main(String[] args) {
        try {
            Long id=13000000001L;
            MiaoshaUser user=new Test().getById(id);
            String token = UUIDUtil.uuid();
            System.out.println(token);
            new MiaoshaUserService().redisService.set(MiaoshaUserKey.token, token, user);
        }catch (NullPointerException e){
            e.printStackTrace();
            e.getCause();
        }

        //if (user==null){
        //System.out.println("User Not Exist");
        //}

    }

}
