package com.stackroute.foodieapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.foodieapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodieapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodieapp.model.Restaurant;
import com.stackroute.foodieapp.service.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurantService")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	/* method to add a restaurant */
	@ApiOperation(value = "Add a product")
	@PostMapping("/addRestaurant")
	public ResponseEntity<?> addNewRestaurant(@RequestBody Restaurant restaurant) {
		try {
			restaurantService.addNewRestaurant(restaurant);

		} catch (DuplicateRestaurantFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@PutMapping("/updateRestaurant/{id}")
	public ResponseEntity<String> updateRestaursant(@PathVariable("id") String id, @RequestParam String comments) {
		try {
			restaurantService.updateRestaurant(id, comments);

		} catch (RestaurantNotFoundException e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Restaurant updated successfully", HttpStatus.OK);

	}

	@ApiOperation(value = "Delete a product")
	@DeleteMapping("/deleteRestaurant/{id}")
	public ResponseEntity<String> deleterestaurant(@PathVariable("id") String id) {
		try {
			restaurantService.deleteRestaurant(id);

		} catch (RestaurantNotFoundException e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Restaurant deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Search a product with an id", response = Restaurant.class)
	@GetMapping("/getRestaurant/{id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable("id") String id) {
		Restaurant restaurant;
		try {
			restaurant = restaurantService.getRestaurantById(id);

		} catch (RestaurantNotFoundException e) {

			return new ResponseEntity<String>("Restaurant not found ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Search a product with an name", response = Restaurant.class)
	@GetMapping("/getRestaurantByName/{name}")
	public @ResponseBody ResponseEntity<?> getRestaurantByName(@PathVariable("name") String name) {
		Restaurant restaurant;
		try {
			restaurant = restaurantService.getRestaurantByName(name);

		} catch (RestaurantNotFoundException e) {

			return new ResponseEntity<String>("Restaurant not found , check the name entered", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/getAllRestaurants")
	public ResponseEntity<?> getAllRestaurants() {
		List<Restaurant> list = new ArrayList<>();
		try {
			list = restaurantService.getAllRestaurants();
		} catch (RestaurantNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
	}

}
