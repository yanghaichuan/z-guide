package com.yhc.example.zguide.user.sev.server.impl;

import java.util.Map;

import com.yhc.example.zguide.common.util.reponse.CommonUtils;
import com.yhc.example.zguide.common.util.reponse.Page;
import com.yhc.example.zguide.common.util.request.Query;
import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.mode.AccountEntity;
import com.yhc.example.zguide.user.sev.dao.AccountDaoMapper;
import com.yhc.example.zguide.user.sev.server.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author yanghaichuan
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDaoMapper accountDaoMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<AccountEntity> listZAccount(Map<String, Object> params) {
		Query query = new Query(params);
		Page<AccountEntity> page = new Page<>(query);
		accountDaoMapper.listForPage(query);
		return page;
	}

    /**
     * 新增
     * @param zAccount
     * @return
     */
	@Override
	public R saveZAccount(AccountEntity zAccount) {
		int count = accountDaoMapper.save(zAccount);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getZAccountById(Long id) {
		AccountEntity zAccount = accountDaoMapper.getObjectById(id);
		return CommonUtils.msg(zAccount);
	}

    /**
     * 修改
     * @param zAccount
     * @return
     */
	@Override
	public R updateZAccount(AccountEntity zAccount) {
		int count = accountDaoMapper.update(zAccount);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = accountDaoMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
