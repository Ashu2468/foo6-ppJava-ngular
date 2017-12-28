import { browser, by, element } from 'protractor';
import { CssSelector } from '@angular/compiler';

describe('FoodieApp', () => {

  beforeEach((done) => done());

  it('should display title', () => {
    expect(browser.getTitle()).toEqual('FoodieApp');

  });

  it('should be redirected to "/search route on opening the application', () => {
    expect(browser.getCurrentUrl()).toContain('/search');

  });

  it('should be able to search for restaurants', () => {
    browser.element(by.id('location')).sendKeys('bangalore');
    browser.element(by.id('cuisine')).sendKeys('chinese');
    browser.element(by.id('search-button')).click();
    expect(browser.getCurrentUrl()).toContain('/search');
    const searchItems = element.all(by.css('.restaurant-card'));
    expect(searchItems.count()).toBeGreaterThan(0);

  });

  it('should display the name of the restaurant on the restaurant card', () => {
    browser.ignoreSynchronization = true;
    const searchItem = element(by.css('.restaurant-name'));
    expect(searchItem.getText()).toContain('Sriracha');

  });

  it('Restaurant address should appear', () => {
    const searchItem = element(by.css('.restaurant-address'));
    expect(searchItem.getText()).toContain('Bangalore');

  });

  it('Restaurant cost of two should appear', () => {
    const searchItem = element(by.css('.restaurant-COT'));
    expect(searchItem.getText()).toContain('0');

  });

  it('should be able to add restaurant to My favourite list', () => {
    browser.element(by.css('.favourite')).click();
    browser.element(by.id('favourites-button')).click();
    expect(browser.getCurrentUrl()).toContain('/favourites');
    browser.sleep(5000);
    const favItems = element.all(by.css('.restaurant-card'));
    expect(favItems.count()).toBe(1);

  });

  it('button should change from "Add favourite" to "Remove" in favourite section', () => {
    const removeItems = element.all(by.css('.remove'));
    expect(removeItems.count()).toBe(1);

  });

  it('should be able to remove the favourite movie from favourite list', () => {
    browser.element(by.css('.remove')).click();
    browser.sleep(2000);
    const _favouriteItem = element.all(by.css('.restaurant-card'));
    expect(_favouriteItem.count()).toBe(0);
    const remItems = element.all(by.css('.remove'));
    expect(remItems.count()).toBe(0);

  });

});​
