package entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="profitability")
public class ProfitabilityEntity extends ActiveModel {
    @Id @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="profit_from_all_activities")
    private Double profitFromAllActivities;

    @Column(name="total_product_sales_costs")
    private Double totalProductSalesCosts;

    @Column(name="result")
    private Double result;

    @OneToOne
    @JoinColumns(
            @JoinColumn(name="app_id", referencedColumnName="id")
    )
    private ApplicationEntity application;

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

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

    public static ArrayList<ProfitabilityEntity> getAll() {
        ArrayList<ActiveModel> list = (ArrayList<ActiveModel>) getAll(ProfitabilityEntity.class);
        ArrayList<ProfitabilityEntity> result = new ArrayList<ProfitabilityEntity>();

        for (ActiveModel elem : list) {
            result.add((ProfitabilityEntity) elem);
        }

        return result;
    }

    public static ProfitabilityEntity getLast() {
        return (ProfitabilityEntity) getLast(ProfitabilityEntity.class);
    }
    
    public static ProfitabilityEntity getById(int id) {
        return (ProfitabilityEntity) getById(id, ProfitabilityEntity.class);
    }
}
