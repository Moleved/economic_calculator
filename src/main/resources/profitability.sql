CREATE TABLE IF NOT EXISTS profitability(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  profit_from_all_activities DOUBLE NOT NULL,
  total_product_sales_costs DOUBLE NOT NULL,
  result DOUBLE NOT NULL
);

CREATE UNIQUE INDEX profitability_id_uindex ON economic_calculator.profitability (id);