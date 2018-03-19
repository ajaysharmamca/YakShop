package com.webshop.shepherd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.shepherd.dvo.Item;
import com.webshop.shepherd.service.producer.ItemsProducer;

//import com.webshop.shepherd.dvo.HerdLoader;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ShepherdApplication.class)
public class ItemProductionTest extends TestCase {

	@Autowired
	ItemsProducer itemsProducer;

	@Test
	public void testProduceItemsAfter12Days() {
		List<Item> items = itemsProducer.produceItems(13);
		
		Item milk = items.get(0);
		Item skin = items.get(1);
		
		assertEquals(1104.48f, milk.getQuantity());
		
		assertEquals(3.0f, skin.getQuantity());
		
		
	}
	
	@Test
	public void testProduceItemsAfter13Days() {
		List<Item> items = itemsProducer.produceItems(14);
		
		Item milk = items.get(0);
		Item skin = items.get(1);
		
		assertEquals(1188.81f, milk.getQuantity());
		assertEquals(4.0f, skin.getQuantity());
		
	}

	@Test
	public void testProduceItemsAfter27Days() {
		List<Item> items = itemsProducer.produceItems(28);
		
		Item milk = items.get(0);
		Item skin = items.get(1);
		
		assertEquals(2359.98f, milk.getQuantity());
		assertEquals(7.0f, skin.getQuantity());
		
	}


}
