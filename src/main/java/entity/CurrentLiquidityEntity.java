package entity;

import javax.persistence.*;

@Entity
@Table(name="current_liquidity")
public class CurrentLiquidityEntity {
    @Id @Column(name="id")
    private int id;
    @Column(name="revolving_assets")
    private double revolvingAssets;
    @OneToOne
    @JoinColumns(
            @JoinColumn(name="liquidity_id", referencedColumnName="id")
    )
    private LiquidityEntity liquidity;

    public LiquidityEntity getLiquidity() {
        return liquidity;
    }

    public void setLiquidity(LiquidityEntity liquidity) {
        this.liquidity = liquidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRevolvingAssets() {
        return revolvingAssets;
    }

    public void setRevolvingAssets(double revolvingAssets) {
        this.revolvingAssets = revolvingAssets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentLiquidityEntity that = (CurrentLiquidityEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.revolvingAssets, revolvingAssets) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(revolvingAssets);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
