package com.stackroute.foodieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapp.dao.RestaurantDAO;
import com.stackroute.foodieapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodieapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodieapp.model.Restaurant;

/**
 * service class to implement our own logic
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;

	public RestaurantDAO getRestaurantDAO() {
		return restaurantDAO;
	}

	public void setRestaurantDAO(RestaurantDAO restaurantDAO) {
		this.restaurantDAO = restaurantDAO;
	}

	/**
	 * method to save a restaurant
	 */
	@Override
	public boolean addNewRestaurant(Restaurant restaurant) throws DuplicateRestaurantFoundException {
		return restaurantDAO.addRestaurant(restaurant);
	}

	/**
	 * method to update the restaurants
	 */
	@Override
	public boolean updateRestaurant(String id, String comments) throws RestaurantNotFoundException {
		return restaurantDAO.updateRestaurant(id, comments);
	}

	/**
	 * method to delete the restaurant from database
	 */
	@Override
	public boolean deleteRestaurant(String id) throws RestaurantNotFoundException {
		return restaurantDAO.deleteRestaurant(id);
	}

	/**
	 * method to search for restaurants based on their ids
	 */

	@Override
	public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
		return restaurantDAO.getRestaurant(id);
	}

	/**
	 * method to search restaurants by their names
	 */
	@Override
	public Restaurant getRestaurantByName(String name) throws RestaurantNotFoundException {
		return restaurantDAO.getRestaurantByName(name);
	}

	/**
	 * method to get all restaurants from the database
	 */
	@Override
	public List<Restaurant> getAllRestaurants() throws RestaurantNotFoundException {
		return restaurantDAO.getAllRestaurant();
	}

}
