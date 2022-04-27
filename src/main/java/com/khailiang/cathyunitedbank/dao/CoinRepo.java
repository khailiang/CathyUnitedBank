package com.khailiang.cathyunitedbank.dao;

import com.khailiang.cathyunitedbank.entity.CoinEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends JpaRepository<CoinEntity,Integer>{
    
}
