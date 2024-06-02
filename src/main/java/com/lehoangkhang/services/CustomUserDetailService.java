package com.lehoangkhang.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lehoangkhang.models.CustomUserDetail;
import com.lehoangkhang.models.User;
import com.lehoangkhang.models.UserRole;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		Set<UserRole> userRoles = user.getUserRoles();

		userRoles.forEach(userRole -> {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
		});

		return new CustomUserDetail(user, authorities);
	}

}
