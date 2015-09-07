package com.wisebirds.sap.dao.account;

import com.wisebirds.sap.domain.account.Account;

public interface AccountDao {

	Account login(String loginId);

}
