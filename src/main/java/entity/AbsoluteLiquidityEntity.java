package entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="absolute_liquidity")
public class AbsoluteLiquidityEntity extends ActiveModel {
    @Id @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="short_financial_investments")
    private double shortFinancialInvestments;
    @Column(name="funds")
    private double funds;
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

    public double getShortFinancialInvestments() {
        return shortFinancialInvestments;
    }

    public void setShortFinancialInvestments(double shortFinancialInvestments) {
        this.shortFinancialInvestments = shortFinancialInvestments;
    }

    public double getShortLiabilities() {
        return shortLiabilities;
    }

    public void setShortLiabilities(double shortLiabilities) {
        this.shortLiabilities = shortLiabilities;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public static ArrayList<AbsoluteLiquidityEntity> getAll() {
        ArrayList<ActiveModel> list = (ArrayList<ActiveModel>) getAll(AbsoluteLiquidityEntity.class);
        ArrayList<AbsoluteLiquidityEntity> result = new ArrayList<AbsoluteLiquidityEntity>();

        for (ActiveModel elem : list) {
            result.add((AbsoluteLiquidityEntity) elem);
        }

        return result;
    }

    public static AbsoluteLiquidityEntity getLast() {
        return (AbsoluteLiquidityEntity) getLast(AbsoluteLiquidityEntity.class);
    }

    public static AbsoluteLiquidityEntity getById(int id) {
        return (AbsoluteLiquidityEntity) getById(id, AbsoluteLiquidityEntity.class);
    }
}
