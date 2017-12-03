package entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="current_liquidity")
public class CurrentLiquidityEntity extends ActiveModel {
    @Id @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="revolving_assets")
    private double revolvingAssets;
    @Column(name="short_liabilities")
    private double shortLiabilities;
    @OneToOne
    @JoinColumns(
            @JoinColumn(name="liquidity_id", referencedColumnName="id")
    )
    private LiquidityEntity liquidity;
    @OneToOne
    @JoinColumns(
            @JoinColumn(name="app_id", referencedColumnName="id")
    )
    private ApplicationEntity application;

    public static ArrayList<CurrentLiquidityEntity> getAll() {
        ArrayList<ActiveModel> list = (ArrayList<ActiveModel>) getAll(CurrentLiquidityEntity.class);
        ArrayList<CurrentLiquidityEntity> result = new ArrayList<CurrentLiquidityEntity>();

        for (ActiveModel elem : list) {
            result.add((CurrentLiquidityEntity) elem);
        }

        return result;
    }

    public static CurrentLiquidityEntity getLast() {
        try {
            return (CurrentLiquidityEntity) getLast(CurrentLiquidityEntity.class);
        } catch (Exception ex) {
            return null;
        }
    }

    public static CurrentLiquidityEntity getById(int id) {
        try {
            return (CurrentLiquidityEntity) getById(id, CurrentLiquidityEntity.class);
        } catch (Exception ex) {
            return null;
        }
    }

    /* Getters and Setters */

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

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

    public double getShortLiabilities() {
        return shortLiabilities;
    }

    public void setShortLiabilities(double shortLiabilities) {
        this.shortLiabilities = shortLiabilities;
    }
}
