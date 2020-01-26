package com.yhc.example.zguide.user.sev.server;

import com.yhc.example.zguide.common.util.reponse.Page;
import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.mode.AccountEntity;

import java.util.Map;


/**
 * 
 * @author yanghaichuan
 */
public interface AccountService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<AccountEntity> listZAccount(Map<String, Object> params);

    /**
     * 新增
     * @param zAccount
     * @return
     */
	R saveZAccount(AccountEntity zAccount);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getZAccountById(Long id);

    /**
     * 修改
     * @param zAccount
     * @return
     */
	R updateZAccount(AccountEntity zAccount);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
