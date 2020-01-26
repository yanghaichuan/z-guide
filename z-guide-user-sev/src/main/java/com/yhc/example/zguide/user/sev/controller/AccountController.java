package com.yhc.example.zguide.user.sev.controller;

import java.util.Map;

import com.yhc.example.zguide.common.util.reponse.Page;
import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.mode.AccountEntity;
import com.yhc.example.zguide.user.sev.server.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author yanghaichuan
 */
@RestController
@RequestMapping("/user/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<AccountEntity> list(@RequestBody Map<String, Object> params) {
		return accountService.listZAccount(params);
	}
		
	/**
	 * 新增
	 * @param zAccount
	 * @return
	 */
	@RequestMapping("/save")
	public R save(@RequestBody AccountEntity zAccount) {
		return accountService.saveZAccount(zAccount);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return accountService.getZAccountById(id);
	}
	
	/**
	 * 修改
	 * @param zAccount
	 * @return
	 */
	@RequestMapping("/update")
	public R update(@RequestBody AccountEntity zAccount) {
		return accountService.updateZAccount(zAccount);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return accountService.batchRemove(id);
	}
	
}
