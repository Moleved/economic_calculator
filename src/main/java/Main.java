import entity.AbsoluteLiquidityEntity;
import entity.LiquidityEntity;
import entity.ProfitabilityEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    public static void main(final String[] args) throws Exception {
//        System.out.println("Processing...");
//        LiquidityEntity liq = new LiquidityEntity();
//        liq.setResult(111.11);
//        liq.setType("bla");
//        liq.save();

//        LiquidityEntity liq1 = (LiquidityEntity) new LiquidityEntity().getById(2);
//        System.out.println(liq1.getId() + liq1.getResult());
//        System.out.println("Done!");
//        ProfitabilityEntity prof = new ProfitabilityEntity();
//        prof.setProfitFromAllActivities(10.0);
//        prof.setResult(20.0);
//        prof.setTotalProductSalesCosts(1.0);
//        prof.save();

        LiquidityEntity liq = new LiquidityEntity();
        liq.setId(333);
        liq.setResult(123.0);
        liq.setType("absolute");
        liq.save();

        AbsoluteLiquidityEntity absLiq = new AbsoluteLiquidityEntity();
        absLiq.setId(13);
        absLiq.setFunds(12.4);
        absLiq.setLiquidity(liq);
        absLiq.setShortFinancialInvestments(124.5);
        absLiq.save();
    }
}