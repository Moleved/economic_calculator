CREATE TABLE IF NOT EXISTS application(
  id INT PRIMARY KEY NOT NULL
) ENGINE=INNODB;

CREATE UNIQUE INDEX absolute_liquidity_id_uindex ON economic_calculator.absolute_liquidity (id);