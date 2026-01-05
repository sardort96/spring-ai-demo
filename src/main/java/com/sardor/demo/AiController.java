package com.sardor.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

	private final ChatClient chatClient;

	public AiController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@GetMapping("/ai")
	public String generate(@RequestParam(value = "prompt", defaultValue = "Tell me a joke about startups in the bay area") String prompt) {
		return this.chatClient.prompt()
			.user(prompt)
			.call()
			.content();
	}
}
