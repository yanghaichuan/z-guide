package com.yhc.example.zguide.goods.sev.server.impl;

import com.yhc.example.zguide.goods.api.mode.GoodsEntity;
import com.yhc.example.zguide.goods.sev.server.GoodsServer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("goodsServer")
public class GoodsServerImpl implements GoodsServer {
    @Override
    public List<GoodsEntity> list() {
        List<GoodsEntity> list = new ArrayList<>();
        GoodsEntity goods = new GoodsEntity();
        goods.setId(1l);
        goods.setGoodsName("娇牌");
        list.add(goods);
        return list;
    }
}
