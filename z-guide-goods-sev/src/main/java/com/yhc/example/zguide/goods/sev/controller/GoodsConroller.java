package com.yhc.example.zguide.goods.sev.controller;

import com.alibaba.fastjson.JSON;
import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.goods.api.mode.GoodsEntity;
import com.yhc.example.zguide.goods.api.server.GoodsHystrixServer;
import com.yhc.example.zguide.goods.sev.kafka.KafkaSender;
import com.yhc.example.zguide.goods.sev.server.GoodsServer;
import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private KafkaSender kafkaSender;

    @RequestMapping(value = "/goods/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R list() {
        UserEntity user = userHystrixServer.getUser();
        List<GoodsEntity> goodsEntityList = goodsServer.list();
        for (GoodsEntity goods : goodsEntityList) {
            goods.setUserId(user.getId());
        }
        return R.data(goodsEntityList);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/goods/save", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public R save(@RequestBody GoodsEntity goods) {
        boolean flag = goodsServer.save(goods);

        if (flag) {
            UserEntity user = new UserEntity();
            user.setId(1l);
            user.setState(2);
            R result = userHystrixServer.updateUser(user);
            if(!result.get("code").toString().equals("0")){
                try {
                    throw new Exception("报错了老板");
                } catch (Exception e) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return R.error();
                }
            }else{
                String jsonString = JSON.toJSONString(goods);
                kafkaSender.send("test","2020010715331252", jsonString);
                return R.ok();
            }

        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/goods/areaList", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R areaList() {
        R areaList = userHystrixServer.areaList();
        return R.data(areaList);
    }
}
