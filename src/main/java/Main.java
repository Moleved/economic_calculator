import entity.AbsoluteLiquidityEntity;
import entity.ActiveModel;
import entity.LiquidityEntity;
import entity.ProfitabilityEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.ArrayList;
import java.util.List;
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
//        liq.setResult(123.0);
//        liq.setType("absolute");
//
//        System.out.println(liq.getId());
//
//        liq.save();
//
//        System.out.println(liq.getId());

        List<ActiveModel> list = liq.getAll();

        for (ActiveModel elem : list) {
            LiquidityEntity foo = (LiquidityEntity) elem;
            System.out.println(foo.getId() + " : " + foo.getResult()+ " : " + foo.getType());
        }
    }
}