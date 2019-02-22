package com.weathersearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weathersearch.entity.User;

@Repository
public interface UserDao extends JpaRepository<User	, Long>{

}
