package com.lehoangkhang.services;

import com.lehoangkhang.models.User;

public interface UserService {
	User findByUserName(String userName);
}
