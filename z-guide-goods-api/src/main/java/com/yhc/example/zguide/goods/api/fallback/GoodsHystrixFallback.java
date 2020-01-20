package com.yhc.example.zguide.goods.api.fallback;

import com.yhc.example.zguide.common.util.R;
import com.yhc.example.zguide.goods.api.server.GoodsHystrixServer;
import org.springframework.stereotype.Component;

@Component
public class GoodsHystrixFallback implements GoodsHystrixServer {
    @Override
    public R list() {
        return R.error("去火星找吧");
    }
}
