package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.exception.UserNotFoundException;
import com.bridgelabz.utility.Response;

public interface IUserService {

	Response addUser(UserDto userDto) throws UserNotFoundException;

	Response deleteUser(int id) throws UserNotFoundException;

	Response updateUser(int id, UserDto userDto);

	List<UserDto> findAll();

	Response getById(int id) throws UserNotFoundException;
}
