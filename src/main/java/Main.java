import entity.LiquidityEntity;
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
        System.out.println("Processing...");
//        LiquidityEntity liq = new LiquidityEntity();
//        liq.setResult(111.11);
//        liq.save();

        LiquidityEntity liq1 = (LiquidityEntity) new LiquidityEntity().getById(2);
        System.out.println(liq1.getId() + liq1.getResult());
        System.out.println("Done!");
    }
}