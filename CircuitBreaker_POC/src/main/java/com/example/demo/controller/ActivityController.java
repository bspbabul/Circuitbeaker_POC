package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.ActivityModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	public RestTemplate restTemplate;

	private final String BORED_API = "https://www.boredapi.com/api/activity";

	@GetMapping
	@CircuitBreaker(name = "randomActivity",fallbackMethod = "fallbackRandomActivity")
	public String getActivity() {
		ActivityModel activityModel = restTemplate.getForObject(BORED_API, ActivityModel.class);
		log.info("Activity received " + activityModel.getActivity());
		return activityModel.getActivity();

	}
	
	public String fallbackRandomActivity(Throwable throwable) {
		return "server is Down wait for minute";
	}

}
