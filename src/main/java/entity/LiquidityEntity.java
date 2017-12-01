package entity;

import javax.persistence.*;

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
    private ApplicationEntity appId;

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

    public ApplicationEntity getAppId() {
        return appId;
    }

    public void setAppId(ApplicationEntity app_id) {
        this.appId = app_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiquidityEntity that = (LiquidityEntity) o;

        if (id != that.id) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}
