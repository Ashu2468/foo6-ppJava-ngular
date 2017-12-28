package com.stackroute.foodieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.foodieapp.model.Restaurant;

/**
 * interface for crud operations
 */
public interface UserRepository extends JpaRepository<Restaurant, Integer> {
	/**
	 * your own methods apart from the simple crud
	 */
	Restaurant findByName(String name);
}
