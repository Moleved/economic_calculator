CREATE TABLE IF NOT EXISTS absolute_liquidity(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  liquidity_id INT NOT NULL,
  funds DOUBLE NOT NULL,
  short_financial_investments DOUBLE NOT NULL,
  FOREIGN KEY (liquidity_id)
    REFERENCES liquidity (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE=INNODB;

CREATE UNIQUE INDEX absolute_liquidity_id_uindex ON economic_calculator.absolute_liquidity (id);
