package com.webshop.shepherd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.shepherd.common.AppConstants;
import com.webshop.shepherd.dvo.Herd;
import com.webshop.shepherd.dvo.Item;
import com.webshop.shepherd.dvo.Yak;
import com.webshop.shepherd.service.producer.impl.ItemsProducerImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ShepherdApplication.class)
public class ItemProductionnInvalidTest extends TestCase {

	@Test
	public void testProductionOfYakAgeLessThanOneYear() {
		
		
		
		Set<Yak> yaks = new HashSet<>();
		
		yaks.add(new Yak("Betty-1", 0.5f, AppConstants.FEMALE));
		yaks.add(new Yak("Betty-2", 0.9f, AppConstants.FEMALE));
		yaks.add(new Yak("Betty-3", 0.75f, AppConstants.FEMALE));
		
		
		Herd herd = mock(Herd.class);
		when (herd.getYaks()).thenReturn(yaks);	
		
		ItemsProducerImpl p = new ItemsProducerImpl();
		p.setYaks(herd.getYaks());
		List<Item> items =  p.produceItems(5);
		
		Item skin = items.get(1);
		
		assertEquals(0.0f, skin.getQuantity());
	}
	
	@Test
	public void testProductionOfYakAgeMoreThanTenYear() {
		
		
		
		Set<Yak> yaks = new HashSet<>();
		
		yaks.add(new Yak("Betty-1", 10.5f, AppConstants.FEMALE));
		yaks.add(new Yak("Betty-2", 10.9f, AppConstants.FEMALE));
		yaks.add(new Yak("Betty-3", 10.75f, AppConstants.FEMALE));
		
		
		Herd herd = mock(Herd.class);
		when (herd.getYaks()).thenReturn(yaks);	
		
		ItemsProducerImpl p = new ItemsProducerImpl();
		p.setYaks(herd.getYaks());
		List<Item> items =  p.produceItems(1);
		
		Item milk = items.get(0);
		Item skin = items.get(1);
		
		assertEquals(0.0f, milk.getQuantity());
		assertEquals(0.0f, skin.getQuantity());
	}
	
	@Test
	public void testProductionOfMaleYaks() {
		
		
		
		Set<Yak> yaks = new HashSet<>();
		
		yaks.add(new Yak("Betty-1", 4.5f, AppConstants.MALE));
		yaks.add(new Yak("Betty-2", 8f, AppConstants.MALE));
		yaks.add(new Yak("Betty-3", 9.5f, AppConstants.MALE));
		
		
		Herd herd = mock(Herd.class);
		when (herd.getYaks()).thenReturn(yaks);	
		
		ItemsProducerImpl p = new ItemsProducerImpl();
		p.setYaks(herd.getYaks());
		List<Item> items =  p.produceItems(12);
		
		Item milk = items.get(0);
		
		assertEquals(0.0f, milk.getQuantity());
	}


}
