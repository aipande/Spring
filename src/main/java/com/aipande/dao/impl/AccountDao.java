package com.aipande.dao.impl;

import com.aipande.dao.IAccountDao;
import com.aipande.entity.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: WangPan
 * Description:
 * Date-Of-Create:2020/7/22-9:59
 */
public class AccountDao implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据账户名称查询账户信息
     *
     * @param accountName
     * @return
     */
    public List<Account> findByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        return accounts;
    }

    /**
     * 根据账户id，修改对应账户的金额
     *
     * @param accountID
     * @param money
     */
    public void updateAccount(Integer accountID, BigDecimal money) {
        jdbcTemplate.update("update account set money = ? where id = ? ",money,accountID);
    }
}
