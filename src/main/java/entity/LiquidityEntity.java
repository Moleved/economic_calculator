package entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="liquidity")
public class LiquidityEntity extends ActiveModel {
    @Id @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="result")
    private Double result;
    @Column(name="type")
    private String type;
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

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public static List<ActiveModel> getAll() {
        return getAll(LiquidityEntity.class);
    }

    public static LiquidityEntity getLast() {
        return (LiquidityEntity) getLast(LiquidityEntity.class);
    }

    public static LiquidityEntity getById(int id) {
        return (LiquidityEntity) getById(id, LiquidityEntity.class);
    }
}
