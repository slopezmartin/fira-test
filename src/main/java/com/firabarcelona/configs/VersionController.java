package com.firabarcelona.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@BasePathAwareController
@RequestMapping("/version")
public class VersionController {

    @Value("${service.version}")
    private String serviceVersion;

    @Value("${service.build.date}")
    private String buildDate;

    @Value("${service.apiCore.version:}")
    private String serviceApiCoreVersion;

    @Value("${fira.app.name:}")
    private String applicationName;

    @Value("${api.consumer.username:}")
    private String apiconsumerUsername;



    @GetMapping()
    @ResponseBody
    public ResponseEntity<Map<String, String>> getVersion() {

        Map<String, String> map = new HashMap<>();
        map.put("Service Version", serviceVersion);
        map.put("Service Name", applicationName);
        map.put("Service Api Core Version", serviceApiCoreVersion);
        map.put("Service Build Date:", buildDate);
        map.put("Service Api Consumer Username", apiconsumerUsername);

        return ResponseEntity.ok(map);
    }
}
