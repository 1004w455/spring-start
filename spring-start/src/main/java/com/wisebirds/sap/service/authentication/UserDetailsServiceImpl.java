package com.wisebirds.sap.service.authentication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wisebirds.sap.dao.account.AccountDao;
import com.wisebirds.sap.domain.account.Account;
import com.wisebirds.sap.domain.account.CustomUserDetails;


@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	// private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

	// @Autowired
	// private AccountRepository accountRepository;
	@Autowired
	private AccountDao accountDao;

	@Override
	public /* UserDetails */ CustomUserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		Account account = null;
		try {
			//account = accountDao.login(loginId);
			Account a = new Account();
			a.setLoginId("ksg");
			a.setPassword("6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b");
			a.setLocale("ko_KR");
			a.setRole("ADMIN");
			account = a;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Wrong loginId or password 1");
		}
		if (account == null) {
			throw new UsernameNotFoundException("Wrong loginId or password 2");
		}

		// UserDetails userDetails = new User(String.valueOf(account.getId()), account.getPassword(), Arrays.asList(new SimpleGrantedAuthority(account.getRole())));
		CustomUserDetails sessionAccount = new CustomUserDetails(account.getLoginId(), account.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_" + account.getRole())), account);
		return sessionAccount;
	}

}
