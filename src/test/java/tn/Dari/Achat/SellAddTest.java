package tn.Dari.Achat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.Dari.Achat.Controllers.SellAdController;

@SpringBootTest
public class SellAddTest {
	
	@Autowired
	private SellAdController selladdcontroller;

	@Test
	void contextLoads() {
		assertThat(selladdcontroller).isNotNull();
	}
}
