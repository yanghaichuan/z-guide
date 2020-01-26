package com.yhc.example.zguide.user.sev.server;

import com.yhc.example.zguide.common.util.PageUtils;
import com.yhc.example.zguide.common.util.reponse.Page;
import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.mode.ShopEntity;

import java.util.Map;


/**
 * 
 * @author yanghaichuan
 */
public interface ShopService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    PageUtils listZShop(Map<String, Object> params);

    /**
     * 新增
     * @param zShop
     * @return
     */
	R saveZShop(ShopEntity zShop);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getZShopById(Long id);

    /**
     * 修改
     * @param zShop
     * @return
     */
	R updateZShop(ShopEntity zShop);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
