package com.webshop.shepherd.service.producer;

import java.util.List;

import com.webshop.shepherd.dvo.Item;

public interface ItemsProducer {
	public List<Item> produceItems(int daysElapsed);
}
