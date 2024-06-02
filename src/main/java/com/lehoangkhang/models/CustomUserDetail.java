package com.lehoangkhang.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
	
	private User user;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO: Return true if the account is not expired.
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO: Return true if the account is not locked.
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO: Return true if the credentials are not expired.
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO: Return true if the user is enabled.
		return user.getEnabled();
	}

}
