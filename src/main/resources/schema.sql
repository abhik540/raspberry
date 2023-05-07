DROP TABLE IF EXISTS system_properties;
CREATE TABLE system_properties (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      system_key VARCHAR(50) NOT NULL,
                      system_value VARCHAR(58) NOT NULL
);