package com.stackroute.foodieapp.service;

import java.util.List;

import com.stackroute.foodieapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodieapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodieapp.model.Restaurant;

public interface RestaurantService {

	public boolean addNewRestaurant(Restaurant restaurant) throws DuplicateRestaurantFoundException;

	public boolean updateRestaurant(String id, String comments) throws RestaurantNotFoundException;

	public boolean deleteRestaurant(String id) throws RestaurantNotFoundException;

	public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;

	public Restaurant getRestaurantByName(String name) throws RestaurantNotFoundException;

	public List<Restaurant> getAllRestaurants() throws RestaurantNotFoundException;

//	public List<Restaurant> getMyRestaurants(String userId) throws RestaurantNotFoundException;

}
