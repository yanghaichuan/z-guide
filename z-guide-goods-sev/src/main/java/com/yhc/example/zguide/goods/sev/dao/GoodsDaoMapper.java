package com.yhc.example.zguide.goods.sev.dao;

import com.yhc.example.zguide.goods.api.mode.GoodsEntity;

import java.util.List;
import java.util.Map;

public interface GoodsDaoMapper {
    List<GoodsEntity> list(Map<String,Object> params);

    GoodsEntity get(Integer id);

    int save(GoodsEntity goods);
}
