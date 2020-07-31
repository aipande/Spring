package com.aipande.dao;

import com.aipande.entity.Account;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: WangPan
 * Description:账户持久层接口
 * Date-Of-Create:2020/7/22-9:54
 */
public interface IAccountDao {

    /**
     * 根据账户名称查询账户信息123
     * @param accountName
     * @return
     */
    public List<Account> findByName(String accountName);

    /**
     * 根据账户id，修改对应账户的金额
     * @param accountID
     * @param money
     */
    public void updateAccount(Integer accountID, BigDecimal money);
}
