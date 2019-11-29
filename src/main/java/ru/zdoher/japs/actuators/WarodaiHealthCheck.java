package ru.zdoher.japs.actuators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import ru.zdoher.japs.service.WaradaiCheckService;


@Component
public class WarodaiHealthCheck implements HealthIndicator {
    private WaradaiCheckService waradaiCheckService;

    public WarodaiHealthCheck(WaradaiCheckService waradaiCheckService) {
        this.waradaiCheckService = waradaiCheckService;
    }

    @Override
    public Health health() {
        try {
            boolean waradaiCheck = waradaiCheckService.check();
            if (waradaiCheck) {
                return Health.up().withDetail("message", "Waradai в порядке").build();
            } else {
                return Health.down().withDetail("message", "Waradai не отвечает!").build();
            }
        } catch (Exception e) {
            return Health.outOfService()
                    .withDetail("message", "Что-то пошло не так во время попытке получение данных с Waradai").build();
        }


    }
}
