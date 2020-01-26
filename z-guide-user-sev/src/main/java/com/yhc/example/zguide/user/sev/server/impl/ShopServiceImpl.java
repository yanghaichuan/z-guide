package com.yhc.example.zguide.user.sev.server.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhc.example.zguide.common.util.PageUtils;
import com.yhc.example.zguide.common.util.reponse.CommonUtils;
import com.yhc.example.zguide.common.util.reponse.Page;
import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.common.util.request.Query;
import com.yhc.example.zguide.user.api.mode.ShopEntity;
import com.yhc.example.zguide.user.sev.dao.ShopDaoMapper;
import com.yhc.example.zguide.user.sev.server.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yanghaichuan
 */
@Service("zShopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDaoMapper shopDaoMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public PageUtils listZShop(Map<String, Object> params) {
		Query query = new Query(params);
		PageHelper.startPage(query.getPageNo(), query.getPageSize());
		List<ShopEntity> list = shopDaoMapper.listForPage(query);
		PageInfo<ShopEntity> page = new PageInfo<>(list);
		return new PageUtils(list,page.getTotal());
	}

    /**
     * 新增
     * @param zShop
     * @return
     */
	@Override
	public R saveZShop(ShopEntity zShop) {
		int count = shopDaoMapper.save(zShop);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getZShopById(Long id) {
		ShopEntity zShop = shopDaoMapper.getObjectById(id);
		return CommonUtils.msg(zShop);
	}

    /**
     * 修改
     * @param zShop
     * @return
     */
	@Override
	public R updateZShop(ShopEntity zShop) {
		int count = shopDaoMapper.update(zShop);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = shopDaoMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
