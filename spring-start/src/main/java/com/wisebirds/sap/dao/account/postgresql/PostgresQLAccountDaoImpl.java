package com.wisebirds.sap.dao.account.postgresql;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.wisebirds.sap.AppContext;
import com.wisebirds.sap.dao.AbstractPostgresQLDAO;
import com.wisebirds.sap.dao.account.AccountDao;
import com.wisebirds.sap.domain.account.Account;

@Component
public class PostgresQLAccountDaoImpl extends AbstractPostgresQLDAO implements AccountDao {

	@Override
	public Account login(String loginId) {
		return pgJdbcTemplate.queryForObject("select * from account limit 1",//
				new BeanPropertyRowMapper<Account>(Account.class),//
				new Object[]{});
	}

}
