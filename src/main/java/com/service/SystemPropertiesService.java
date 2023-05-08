package com.service;

import com.model.SystemProperties;
import com.repository.SystemPropertiesRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemPropertiesService {

    private final SystemPropertiesRepository systemPropertiesRepository;

    public List<SystemProperties> findAll() {
        return systemPropertiesRepository.findAll();
    }
    public SystemProperties findByKey(String key) {
        return systemPropertiesRepository.findByKey(key);
    }
}
