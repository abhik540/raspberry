package com.repository;

import com.model.SystemProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SystemPropertiesRepository extends JpaRepository<SystemProperties, Integer> {

    @Query(value = "SELECT * FROM system_properties WHERE system_key=:key LIMIT 1", nativeQuery = true)
    SystemProperties findByKey(@Param("key") String key);

}
