import entity.*;
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

public class Main implements Runnable {
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

        ApplicationEntity app = new ApplicationEntity();
//        app.setId(13);
//        app.save();

//        LiquidityEntity liq = new LiquidityEntity();
//        liq.setResult(123.0);
//        liq.setType("absolute");
//        liq.setAppId(app);
//
//        liq.save();

//
//        List<ActiveModel> list = liq.getAll();
//
//        for (ActiveModel elem : list) {
//            LiquidityEntity foo = (LiquidityEntity) elem;
//            System.out.println(foo.getId() + " : " + foo.getResult()+ " : " + foo.getType());
//        }
//
        ApplicationEntity last = (ApplicationEntity) app.getLast();
//
        System.out.println(last.getId());

        LiquidityEntity liq = new LiquidityEntity();

        liq.setResult(1.1);
        liq.setType("absolute");

        liq.save();

        CurrentLiquidityEntity cliq = new CurrentLiquidityEntity();

        cliq.setRevolvingAssets(2.3);
        cliq.setShortLiabilities(43);
        cliq.setLiquidity(liq);

        cliq.save();

        System.out.println(cliq.getLiquidity().getId());
    }

    public void run() {

    }
}