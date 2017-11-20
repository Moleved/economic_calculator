CREATE TABLE IF NOT EXISTS liquidity(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  result DOUBLE NOT NULL,
  type VARCHAR(255) NOT NULL
) ENGINE=INNODB;

CREATE UNIQUE INDEX liquidity_id_uindex ON economic_calculator.liquidity (id);
