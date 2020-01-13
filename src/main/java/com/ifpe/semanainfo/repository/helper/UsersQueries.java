package com.ifpe.semanainfo.repository.helper;

import java.util.List;

import com.ifpe.semanainfo.model.UserModel;

public interface UsersQueries {

	public List<String> permissions(UserModel userModel);
}
