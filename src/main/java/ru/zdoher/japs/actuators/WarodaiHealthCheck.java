package ru.zdoher.japs.actuators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import ru.zdoher.japs.config.YAMLConfig;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WarodaiHealthCheck implements HealthIndicator {
    private YAMLConfig yamlConfig;

    public WarodaiHealthCheck(YAMLConfig yamlConfig) {
        this.yamlConfig = yamlConfig;
    }

    @Override
    public Health health() {

        try {
            URL siteURL = new URL(yamlConfig.getWaradai_url());
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                return Health.up().withDetail("message", "Waradai в порядке").build();
            }
        } catch (Exception e) {
            return Health.outOfService()
                    .withDetail("message", "Что-то пошло не так во время попытке получение данных с Waradai").build();
        }

        return Health.down().withDetail("message", "Waradai не отвечает!").build();
    }
}
