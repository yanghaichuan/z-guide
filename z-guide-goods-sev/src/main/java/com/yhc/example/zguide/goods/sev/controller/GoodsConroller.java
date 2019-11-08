package com.yhc.example.zguide.goods.sev.controller;

import com.yhc.example.zguide.common.util.R;
import com.yhc.example.zguide.goods.api.mode.GoodsEntity;
import com.yhc.example.zguide.goods.api.server.GoodsHystrixServer;
import com.yhc.example.zguide.goods.sev.server.GoodsServer;
import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsConroller implements GoodsHystrixServer {
    @Autowired
    private UserHystrixServer userHystrixServer;

    @Autowired
    private GoodsServer goodsServer;

    @RequestMapping(value = "/goods/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R list() {
        UserEntity user = userHystrixServer.getUser();
        List<GoodsEntity> goodsEntityList = goodsServer.list();
        for(GoodsEntity goods:goodsEntityList){
            goods.setUserId(user.getId());
        }
        return R.data(goodsEntityList);
    }
}
