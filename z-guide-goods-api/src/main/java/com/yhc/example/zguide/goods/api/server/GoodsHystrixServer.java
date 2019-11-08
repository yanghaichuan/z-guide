package com.yhc.example.zguide.goods.api.server;

import com.yhc.example.zguide.goods.api.fallback.GoodsHystrixFallback;
import com.yhc.example.zguide.goods.api.mode.GoodsEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "guide-goods",fallback = GoodsHystrixFallback.class)
public interface GoodsHystrixServer {
    @RequestMapping(value = "/goods/list",method = RequestMethod.GET)
    public List<GoodsEntity> list();
}
