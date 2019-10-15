package com.example.springretry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@Retryable(value = { RuntimeException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	@GetMapping(value="/retry")
	@ExceptionHandler({ Exception.class })
	public String validateSPringRetryCapability() throws RuntimeException {
		System.out.println("==========Inside validateSPringRetryCapability retry ====================");
		System.out.println("Inside RestController mathod..");
		if(true) {
			throw new ArithmeticException("This is Arithmetic Exception");
		}
		return "success";
	}
	@Recover
	public String getBackendResponseFallback(RuntimeException e) {
		System.out.println("============Inside Revover Method==================");
		return "failedResponse";
	}
}
