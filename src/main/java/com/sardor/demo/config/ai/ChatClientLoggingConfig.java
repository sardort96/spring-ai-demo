package com.sardor.demo.config.ai;

import org.springframework.ai.chat.client.ChatClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientLoggingConfig {

	@Bean
	InfoLoggerAdvisor infoLoggerAdvisor() {
		return new InfoLoggerAdvisor();
	}

	@Bean
	ChatClientCustomizer loggingChatClientCustomizer(InfoLoggerAdvisor infoLoggerAdvisor) {
		return builder -> builder.defaultAdvisors(infoLoggerAdvisor);
	}
}
