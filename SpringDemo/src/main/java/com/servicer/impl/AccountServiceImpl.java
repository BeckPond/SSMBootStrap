package com.servicer.impl;
/*
账户业务层实现方法
 */

import com.dao.IAccountDao;
import com.dao.impl.AccountDaoImpl;
import com.servicer.IAccountService;

public class AccountService implements IAccountService {
    private IAccountDao accountDao =new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
