package tn.Dari.Achat.EventListner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class RunnableTaskBeanConfig {
	
	@Bean
	public RunnableTask task() {
		return new RunnableTask();
	}

}
