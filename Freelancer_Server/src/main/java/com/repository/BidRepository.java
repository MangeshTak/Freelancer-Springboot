package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.entity.Bid;
import com.entity.Projects;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface BidRepository extends CrudRepository<Bid, Integer> {
   
}
