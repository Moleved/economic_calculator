package entity;

import javax.persistence.*;
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

    public static Object getLast() {
        return getLast(LiquidityEntity.class);
    }

    public static Object getById(int id) {
        return getById(id, LiquidityEntity.class);
    }
}
