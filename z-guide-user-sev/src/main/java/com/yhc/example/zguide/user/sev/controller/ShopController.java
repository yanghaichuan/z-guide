package com.yhc.example.zguide.user.sev.controller;

import java.util.Map;

import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.mode.ShopEntity;
import com.yhc.example.zguide.user.sev.server.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author yanghaichuan
 */
@RestController
@RequestMapping("/user/shop")
public class ShopController{
	
	@Autowired
	private ShopService shopService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public R list(@RequestBody Map<String, Object> params) {
		return R.data(shopService.listZShop(params));
	}
		
	/**
	 * 新增
	 * @param zShop
	 * @return
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ShopEntity zShop) {
		return shopService.saveZShop(zShop);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return shopService.getZShopById(id);
	}
	
	/**
	 * 修改
	 * @param zShop
	 * @return
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ShopEntity zShop) {
		return shopService.updateZShop(zShop);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return shopService.batchRemove(id);
	}
	
}
