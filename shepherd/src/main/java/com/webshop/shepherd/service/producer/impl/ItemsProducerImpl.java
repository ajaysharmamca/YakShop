package com.webshop.shepherd.service.producer.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.shepherd.common.AppConstants;
import com.webshop.shepherd.dvo.Item;
import com.webshop.shepherd.dvo.Yak;
import com.webshop.shepherd.service.loader.HerdLoader;
import com.webshop.shepherd.service.producer.ItemsProducer;

@Service
public class ItemsProducerImpl implements ItemsProducer {
	
	@Autowired
	HerdLoader heardLoader;
	
	Set<Yak> yaks;
	
	@PostConstruct
	public void initYaks() {
		yaks = heardLoader.getHerd().getYaks();
	}
	
	public void setYaks(Set<Yak> yaks) {
		this.yaks = yaks;
	}
	public List<Item> produceItems(int daysElapsed) {
		List<Item> items = new ArrayList<>();
		items.add(produceMilk(daysElapsed));
		items.add(produceWool(daysElapsed));
		
		return items;
	}
	//This method will be used to produce milk on daily basis
	public Item produceMilk(int daysElapsed) {
		float milkQuantity = 0.0f;
		float ageInDays = 0.0f;
		
		for (Yak yak : yaks) {
			
			if (yak.getSex().equals(AppConstants.FEMALE)) {
				ageInDays = yak.getAge() * AppConstants.YAK_YEAR_DAYS;
				
				for (float day = ageInDays; day < ageInDays + daysElapsed && (day < (AppConstants.YAK_YEAR_DAYS * AppConstants.YAK_MAX_AGE)); day++) {
					milkQuantity += ( AppConstants.MILK_MAX_PRODUCTION - (day * AppConstants.MILK_PRODUCTION_CONSTANT));
				}
			}
			
		}
		
		Item item = new Item(
				1, AppConstants.ITEM_MILK, Float.valueOf(new DecimalFormat("#.000").format(milkQuantity)), AppConstants.UNIT_LITER, 0, AppConstants.STATE_PRODUCED ); 
		
		return item;
	}
	
		
	public Item produceWool(int daysElapsed) {
		// As the wool quantity not given yet, let us take it fixed as one unit
		int woolQuantity = 0;
		float ageInDays = 0.0f;
	
		for (Yak yak : yaks) {
			
			ageInDays = yak.getAge() * AppConstants.YAK_YEAR_DAYS;
			
			// Check the yak can be shaved when he is greater then 1 year and dies at 10
			
			for (float day = ageInDays; day < ageInDays + daysElapsed - 1 && day >= AppConstants.YAK_YEAR_DAYS
					&& day < (AppConstants.YAK_YEAR_DAYS * AppConstants.YAK_MAX_AGE); day += (AppConstants.WOOL_MIN_SHAVE_DAYS + (day * AppConstants.WOOL_PRODUCTION_CONSTANT))) {
				woolQuantity += 1;
			}
			
			
		}
		
		Item item = new Item(
				2, AppConstants.ITEM_WOOL, woolQuantity, AppConstants.UNIT_SKIN, 0, AppConstants.STATE_PRODUCED ); 
		
		return item;
		
	}
	
}
