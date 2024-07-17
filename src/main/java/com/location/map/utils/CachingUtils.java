package com.location.map.utils;

import static com.location.map.service.CityService.CITIES_CACHE;
import static java.util.Objects.nonNull;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CachingUtils {
    private CacheManager cacheManager;

    public static void longOperation() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
        }
    }

    @Scheduled(fixedRate = 30000)
    public void evictCitiesCache() {
        evictAllCacheValues(CITIES_CACHE);
    }

    public void evictAllCacheValues(String cacheName) {
        log.info("Evicting cache: {}", cacheName);
        if(nonNull(cacheManager.getCache(cacheName)))
            cacheManager.getCache(cacheName).clear();
    }
}
