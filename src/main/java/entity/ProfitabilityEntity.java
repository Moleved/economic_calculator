package entity;

import javax.persistence.*;

@Entity
@Table(name="profitability")
public class ProfitabilityEntity {
    @Id @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="profit_from_all_activities")
    private Double profitFromAllActivities;

    @Column(name="total_product_sales_costs")
    private Double totalProductSalesCosts;

    @Column(name="result")
    private Double result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getProfitFromAllActivities() {
        return profitFromAllActivities;
    }

    public void setProfitFromAllActivities(Double profitFromAllActivities) {
        this.profitFromAllActivities = profitFromAllActivities;
    }

    public Double getTotalProductSalesCosts() {
        return totalProductSalesCosts;
    }

    public void setTotalProductSalesCosts(Double totalProductSalesCosts) {
        this.totalProductSalesCosts = totalProductSalesCosts;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfitabilityEntity that = (ProfitabilityEntity) o;

        if (id != that.id) return false;
        if (profitFromAllActivities != null ? !profitFromAllActivities.equals(that.profitFromAllActivities) : that.profitFromAllActivities != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profitFromAllActivities != null ? profitFromAllActivities.hashCode() : 0);
        return result;
    }
}
