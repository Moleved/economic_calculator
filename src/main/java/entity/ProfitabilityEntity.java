package entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    public String getCreatedAt() {
        DateFormat resultFormat = new SimpleDateFormat("yy-MM-dd");
        return resultFormat.format(createdAt);
    }

    public String toStr() {
        return "profitFromAllActivities:" + profitFromAllActivities +
                ",totalProductSalesCosts:" + totalProductSalesCosts +
                ",result:" + getResult() +
                ",date:" + getCreatedAt();
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
    
    public static ProfitabilityEntity getById(Long id) {
        return (ProfitabilityEntity) getById(id, ProfitabilityEntity.class);
    }

    /* Getters and Setters */

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
}
