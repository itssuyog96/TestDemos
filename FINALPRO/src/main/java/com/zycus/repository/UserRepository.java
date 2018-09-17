package com.zycus.repository;

import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
