package com.stackroute.foodieapp.dao;

import java.util.List;

import com.stackroute.foodieapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodieapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodieapp.model.Restaurant;

public interface RestaurantDAO {

	public boolean addRestaurant(Restaurant restaurant) throws DuplicateRestaurantFoundException;

	public boolean updateRestaurant(String id, String comments) throws RestaurantNotFoundException;

	public boolean deleteRestaurant(String id) throws RestaurantNotFoundException;

	public Restaurant getRestaurant(String id) throws RestaurantNotFoundException;

	public Restaurant getRestaurantByName(String name) throws RestaurantNotFoundException;

	public List<Restaurant> getAllRestaurant() throws RestaurantNotFoundException;

//	public List<Restaurant> getMyRestaurant(String userId) throws RestaurantNotFoundException;

}
