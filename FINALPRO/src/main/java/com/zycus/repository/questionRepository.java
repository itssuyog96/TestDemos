package com.zycus.repository;

import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.Question;



public interface questionRepository extends CrudRepository<Question,Integer> {

}
