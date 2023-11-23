package uz.yangaliev.userservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/retry-one")
    @Retry(name = "retry-api-1", fallbackMethod = "retryFailResponse1")
    public String retryFirst() {
        logger.info("retry-one request");
        errorMethod();
        return "Retry API 1";
    }

    @GetMapping("/retry-two")
    @Retry(name = "retry-api-2", fallbackMethod = "retryFailResponse2")
    public String retrySecond() {
        logger.info("retry-two request");
        errorMethod();
        return "Retry API 2";
    }

    @GetMapping("/circuit-breaker-work")
    @CircuitBreaker(name = "default", fallbackMethod = "circuitBreakerWorkError")
    public String circuitBreakerWork() {
        logger.info("circuit-breaker request");
        errorMethod();
        return "Circuit Breaker API";
    }

    @GetMapping("/rate-limiter-work")
    @RateLimiter(name = "my-rate-limiter")
    public String rateLimiterWork() {
        return "Rate Limiter API";
    }

    @GetMapping("/bulkhead-work")
    @Bulkhead(name = "my-bulkhead")
    public String bulkheadWork() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Bulkhead API";
    }

    public String circuitBreakerWorkError(Exception e) {
        return "Circuit Breaker Request Failed!!!";
    }

    public String retryFailResponse1(Exception e) {
        return "Request 1 Failed!!!";
    }

    public String retryFailResponse2(Exception e) {
        return "Request 2 Failed!!!";
    }

    private void errorMethod() {
        throw new RuntimeException();
    }
}
