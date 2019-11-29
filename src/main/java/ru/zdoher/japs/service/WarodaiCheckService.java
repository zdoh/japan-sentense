package ru.zdoher.japs.service;

import org.springframework.stereotype.Service;
import ru.zdoher.japs.config.YAMLConfig;

import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WarodaiCheckService {
    private YAMLConfig yamlConfig;

    public WarodaiCheckService(YAMLConfig yamlConfig) {
        this.yamlConfig = yamlConfig;
    }

    public boolean check() throws Exception {
        URL siteURL = new URL(yamlConfig.getWarodai_url());
        HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(3000);
        connection.connect();
        return connection.getResponseCode() == 200;
    }
}
