package com.repository;


import com.model.SystemProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemPropertiesRepository extends JpaRepository<SystemProperties, Integer> {

    @Query(value = "SELECT * FROM system_properties WHERE system_key=:key LIMIT 1", nativeQuery = true)
    Optional<SystemProperties> getSystemPropertiesBySystemKey(@Param("key") String key);


    @Query(value = "SELECT * FROM system_properties", nativeQuery = true)
    List<SystemProperties> getAll();
}
