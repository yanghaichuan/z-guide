package com.yhc.example.zguide.goods.sev.server;

import com.yhc.example.zguide.goods.api.mode.GoodsEntity;

import java.util.List;

public interface GoodsServer {
    public List<GoodsEntity> list();

    public boolean save(GoodsEntity goods);
}
