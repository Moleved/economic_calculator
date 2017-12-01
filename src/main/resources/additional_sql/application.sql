CREATE TABLE IF NOT EXISTS application(
  id INT PRIMARY KEY NOT NULL
) ENGINE=INNODB;

CREATE UNIQUE INDEX application_id_uindex ON economic_calculator.application (id);
