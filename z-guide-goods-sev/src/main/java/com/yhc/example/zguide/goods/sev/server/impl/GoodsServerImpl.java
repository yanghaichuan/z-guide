package com.yhc.example.zguide.goods.sev.server.impl;

import com.yhc.example.zguide.goods.api.mode.GoodsEntity;
import com.yhc.example.zguide.goods.sev.dao.GoodsDaoMapper;
import com.yhc.example.zguide.goods.sev.server.GoodsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsServer")
public class GoodsServerImpl implements GoodsServer {
    @Autowired
    GoodsDaoMapper goodsDaoMapper;

    @Override
    public List<GoodsEntity> list() {
        Map<String, Object> params = new HashMap<>();
        List<GoodsEntity> list = goodsDaoMapper.list(params);
        return list;
    }

    @Override
    public boolean save(GoodsEntity goods) {
        boolean flag = false;
        int i = goodsDaoMapper.save(goods);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }
}
