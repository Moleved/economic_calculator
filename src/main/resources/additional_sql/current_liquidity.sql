CREATE TABLE IF NOT EXISTS current_liquidity (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  liquidity_id INT NOT NULL,
  app_id INT NOT NULL,
  revolving_assets DOUBLE NOT NULL,
  short_liabilities DOUBLE NOT NULL,
  FOREIGN KEY (liquidity_id)
    REFERENCES liquidity (id)
    ON DELETE RESTRICT
    ON UPdATE RESTRICT,
  FOREIGN KEY (app_id)
    REFERENCES application (id)
) ENGINE=INNODB;

CREATE UNIQUE INDEX current_liquidity_id_uindex ON economic_calculator.current_liquidity (id);
