package com.webshop.shepherd;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.shepherd.dvo.Yak;
import com.webshop.shepherd.service.loader.HerdLoader;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ShepherdApplication.class)
public class HerdLoaderTest extends TestCase {
	
	@Autowired
	HerdLoader herdLoader;
	
	@Test
	public void testInputHerdXMLLoad() {
		Set<Yak> yaks = herdLoader.getHerd().getYaks();
		assertNotNull(yaks);

	}
	
	/*@Test
	public void testGetMilkInStock() {
		Yak yak1 = new Yak();
		yak1.setName("Betty-1");
		yak1.setAge(4f);
		yak1.setSex("f");
		yak1.setAgeLastShaved(4f);

		Yak yak2 = new Yak();
		yak2.setName("Betty-2");
		yak2.setAge(8f);
		yak2.setSex("f");
		yak2.setAgeLastShaved(8f);

		Yak yak3 = new Yak();
		yak3.setName("Betty-3");
		yak3.setAge(9.5f);
		yak3.setSex("f");
		yak3.setAgeLastShaved(9.5f);

		Set<Yak> yaks = new HashSet<Yak>();
		yaks.add(yak1);
		yaks.add(yak2);
		yaks.add(yak3);
		
		YakItemProducerGroup producerGroup = new YakItemProducerGroup();

		YakShopKeeper.getHerd().setYaks(yaks);

		float milkL = YakShopKeeper.getMilkInStock(13);
		assertEquals(milkL, 1104.48f);
	}*/

}
