package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.utility.Response;

public interface IUserService {

	Response addUser(UserDto userDto);

	Response deleteUser(int id);

	Response updateUser(int id, UserDto userDto);

	List<UserDto> findAll();

	Response getById(int id);
}
