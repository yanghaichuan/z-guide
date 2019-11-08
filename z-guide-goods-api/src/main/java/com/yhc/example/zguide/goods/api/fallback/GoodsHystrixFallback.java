package com.yhc.example.zguide.goods.api.fallback;

import com.yhc.example.zguide.goods.api.mode.GoodsEntity;
import com.yhc.example.zguide.goods.api.server.GoodsHystrixServer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GoodsHystrixFallback implements GoodsHystrixServer {
    @Override
    public List<GoodsEntity> list() {
        List<GoodsEntity> list = new ArrayList<>();
        GoodsEntity goods = new GoodsEntity();
        goods.setId(500l);
        goods.setGoodsName("去火星找吧");
        list.add(goods);
        return list;
    }
}
