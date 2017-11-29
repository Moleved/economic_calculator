CREATE TABLE IF NOT EXISTS liquidity(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  app_id INT NOT NULL,
  result DOUBLE NOT NULL,
  type VARCHAR(255) NOT NULL,
  FOREIGN KEY (app_id)
    REFERENCES application (id)
) ENGINE=INNODB;

CREATE UNIQUE INDEX liquidity_id_uindex ON economic_calculator.liquidity (id);
