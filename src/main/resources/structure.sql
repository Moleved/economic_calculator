CREATE DATABASE IF NOT EXISTS economic_calculator;

USE economic_calculator;

CREATE TABLE IF NOT EXISTS profitability(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  profit_from_all_activities DOUBLE NOT NULL,
  total_product_sales_costs DOUBLE NOT NULL,
  result DOUBLE NOT NULL
);

CREATE UNIQUE INDEX profitability_id_uindex ON economic_calculator.profitability (id);

CREATE TABLE IF NOT EXISTS liquidity(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  result DOUBLE NOT NULL,
  type VARCHAR(255) NOT NULL
) ENGINE=INNODB;

CREATE UNIQUE INDEX liquidity_id_uindex ON economic_calculator.liquidity (id);

CREATE TABLE IF NOT EXISTS current_liquidity (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  liquidity_id INT NOT NULL,
  revolving_assets DOUBLE NOT NULL,
  FOREIGN KEY (liquidity_id)
    REFERENCES liquidity (id)
    ON DELETE RESTRICT
    ON UPdATE RESTRICT
) ENGINE=INNODB;

CREATE UNIQUE INDEX current_liquidity_id_uindex ON economic_calculator.current_liquidity (id);

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
