package com.bridgelabz.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.exception.UserNotFoundException;
import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserRepo;
import com.bridgelabz.utility.Response;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Response addUser(UserDto userDto) throws UserNotFoundException {
		User user = modelMapper.map(userDto, User.class);
		String find = userDto.getEmail();
		if (find.matches(user.getEmail())) {
			throw new UserNotFoundException(
					String.format("!!! User Details has been already entered in the Database !!!"));
		}
		User addU = userRepo.save(user);
		Response response = new Response("The response message : User Information Sucessfully added to the DataBase",
				200, addU);
		return response;
	}

	@Override
	public Response deleteUser(int id) throws UserNotFoundException {
		Optional<User> find = userRepo.findById(id);
		if (!find.isPresent()) {
			throw new UserNotFoundException(String.format(
					"User Details not found with id " + id + ". Kindly check the entered Information for Deleting"));
		}
		userRepo.deleteById(id);
		Response response = new Response(
				"The response message : User Information Sucessfully deleted from the DataBase", 200, id);
		return response;
	}

	@Override
	public Response updateUser(int id, UserDto userDto) {
		User change = modelMapper.map(userDto, User.class);
		change.setId(id);
		User update = userRepo.save(change);

		Response response = new Response("The response message : User Information Sucessfully updated to the DataBase",
				200, update);
		return response;
	}

	@Override
	public List<UserDto> findAll() {
		List<User> user = userRepo.findAll();
		Type userType = new TypeToken<List<UserDto>>() {

		}.getType();
		List<UserDto> userDto = modelMapper.map(user, userType);
		return userDto;
	}

	@Override
	public Response getById(int id) throws UserNotFoundException {
		Optional<User> find = userRepo.findById(id);
		if (!find.isPresent()) {
			throw new UserNotFoundException(
					String.format("User not found with id " + id + ". Kindly check the entered Information"));
		}
		UserDto dto = modelMapper.map(find, UserDto.class);
		Response response = new Response(
				"The response message : User Information Sucessfully retrieved from the DataBase", 200, dto);

		return response;
	}

}
