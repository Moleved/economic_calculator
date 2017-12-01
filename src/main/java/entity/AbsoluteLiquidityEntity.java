package entity;

import javax.persistence.*;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbsoluteLiquidityEntity that = (AbsoluteLiquidityEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.shortFinancialInvestments, shortFinancialInvestments) != 0) return false;
        if (Double.compare(that.funds, funds) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(shortFinancialInvestments);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(funds);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
