package com.aipande.service.impl;

import com.aipande.dao.IAccountDao;
import com.aipande.entity.Account;
import com.aipande.service.IAccountService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: WangPan
 * Description:
 * Date-Of-Create:2020/7/22-9:52
 */
public class AccountService implements IAccountService {

    private IAccountDao accountDao;

    public AccountService(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 转账操作
     *
     * @param sourceAccount
     * @param targetAccount
     * @param money
     */
    public void transfer(String sourceAccount, String targetAccount, BigDecimal money) throws Exception {
        //1.查询转出账户信息
        Account source = null;
        List<Account> accounts = accountDao.findByName(sourceAccount);
        if(accounts == null || accounts.size() == 0 || accounts.size()>1 || accounts.get(0).getMoney().compareTo(money)<0 ){
            throw  new Exception(sourceAccount+"账户信息异常！");
        }else{
            source = accounts.get(0);
        }
        //2.查询转入账户信息
        Account target = null;
        List<Account> accountsTarget = accountDao.findByName(targetAccount);
        if(accountsTarget == null || accountsTarget.size() == 0 || accountsTarget.size()>1){
            throw  new Exception(targetAccount+"账户信息异常！");
        }else{
            target = accountsTarget.get(0);
        }
        //3.转出账户减钱
        accountDao.updateAccount(source.getId(),source.getMoney().subtract(money));
        /*int a = 1/0;*/
        //4.转入账户加钱
        accountDao.updateAccount(target.getId(),target.getMoney().add(money));
    }
}
