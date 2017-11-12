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
        LiquidityEntity liq = new LiquidityEntity();
        liq.setResult(111.11);
        liq.save();
        System.out.println("Done!");
    }
}