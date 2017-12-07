CREATE DATABASE IF NOT EXISTS economic_calculator;

USE economic_calculator;

CREATE TABLE IF NOT EXISTS application(
  id BIGINT PRIMARY KEY NOT NULL
) ENGINE=INNODB;

CREATE UNIQUE INDEX application_id_uindex ON economic_calculator.application (id);

CREATE TABLE IF NOT EXISTS profitability(
  id BIGINT PRIMARY KEY NOT NULL,
  app_id BIGINT NOT NULL,
  profit_from_all_activities DOUBLE NOT NULL,
  total_product_sales_costs DOUBLE NOT NULL,
  result DOUBLE NOT NULL,
  FOREIGN KEY (app_id)
  REFERENCES application (id),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE UNIQUE INDEX profitability_id_uindex ON economic_calculator.profitability (id);

CREATE TABLE IF NOT EXISTS liquidity(
  id BIGINT PRIMARY KEY NOT NULL,
  app_id BIGINT NOT NULL,
  result DOUBLE NOT NULL,
  type VARCHAR(255) NOT NULL,
  FOREIGN KEY (app_id)
  REFERENCES application (id),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE UNIQUE INDEX liquidity_id_uindex ON economic_calculator.liquidity (id);

CREATE TABLE IF NOT EXISTS current_liquidity (
  id BIGINT PRIMARY KEY NOT NULL,
  liquidity_id BIGINT NOT NULL,
  app_id BIGINT NOT NULL,
  revolving_assets DOUBLE NOT NULL,
  short_liabilities DOUBLE NOT NULL,
  FOREIGN KEY (liquidity_id)
  REFERENCES liquidity (id)
    ON DELETE RESTRICT
    ON UPdATE RESTRICT,
  FOREIGN KEY (app_id)
  REFERENCES application (id),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE UNIQUE INDEX current_liquidity_id_uindex ON economic_calculator.current_liquidity (id);

CREATE TABLE IF NOT EXISTS absolute_liquidity(
  id BIGINT PRIMARY KEY NOT NULL,
  liquidity_id BIGINT NOT NULL,
  app_id BIGINT NOT NULL,
  funds DOUBLE NOT NULL,
  short_financial_investments DOUBLE NOT NULL,
  short_liabilities DOUBLE NOT NULL,
  FOREIGN KEY (liquidity_id)
  REFERENCES liquidity (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  FOREIGN KEY (app_id)
  REFERENCES application (id),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE UNIQUE INDEX absolute_liquidity_id_uindex ON economic_calculator.absolute_liquidity (id);
