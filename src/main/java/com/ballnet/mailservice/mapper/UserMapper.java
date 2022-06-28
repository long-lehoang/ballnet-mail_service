package com.ballnet.mailservice.mapper;

import com.ballnet.mailservice.entity.UserEntity;
import com.ballnet.mailservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User toModel(UserEntity userEntity);
  UserEntity toEntity(User user);
}
