package com.icekiwi.banking.converters;

import java.time.Instant;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icekiwi.banking.dto.UserDto;
import com.icekiwi.banking.models.User;
import com.icekiwi.banking.repositories.OperationRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;
    private OperationRepository operationRepository;

    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        userDto.setOperationCount((int) operationRepository.countByUser(user));
        userDto.setDailyOperationCount((int) operationRepository.countByUserAndCreationDate(user, new Date()));
        return userDto;
    }

    public User convertUserDtoToUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        return user;
    }

}
