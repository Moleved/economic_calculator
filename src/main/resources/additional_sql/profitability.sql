CREATE TABLE IF NOT EXISTS profitability(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  app_id INT NOT NULL,
  profit_from_all_activities DOUBLE NOT NULL,
  total_product_sales_costs DOUBLE NOT NULL,
  result DOUBLE NOT NULL,
  FOREIGN KEY (app_id)
    REFERENCES application (id)
);

CREATE UNIQUE INDEX profitability_id_uindex ON economic_calculator.profitability (id);
