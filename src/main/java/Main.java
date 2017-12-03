import entity.CurrentLiquidityEntity;
import processors.CurrentLiquidityProcessor;

import java.util.HashMap;

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

//        ApplicationEntity app = new ApplicationEntity();
//        app.setId(15);
//        app.save();

//        LiquidityEntity liq = new LiquidityEntity();
//        liq.setResult(123.0);
//        liq.setType("absolute");
//        liq.setApplication(app);
//
//        liq.save();



//        ApplicationEntity last = (ApplicationEntity) app.getLast();
//
//        System.out.println(last.getId());
//
//        LiquidityEntity liq = new LiquidityEntity();
//
//        liq.setResult(1.1);
//        liq.setType("absolute");
//        liq.setApplication(last);
//
//        liq.save();
//
//        CurrentLiquidityEntity cliq = new CurrentLiquidityEntity();
//
//        cliq.setRevolvingAssets(2.3);
//        cliq.setShortLiabilities(43);
//        cliq.setLiquidity(liq);
//        cliq.setApplication(last);
//
//        cliq.save();
//
//        System.out.println(cliq.getLiquidity().getId());
//
//        List<ActiveModel> list = liq.getAll();
//
//        for (ActiveModel elem : list) {
//            LiquidityEntity foo = (LiquidityEntity) elem;
//            System.out.println(foo.getId() + " : " + foo.getResult()+ " : " + foo.getType());
//        }

        CurrentLiquidityEntity entity = new CurrentLiquidityEntity();
        entity.setRevolvingAssets(75);
        entity.setShortLiabilities(5);

        CurrentLiquidityProcessor dec = new CurrentLiquidityProcessor(14, entity);

        dec.perform();
    }

    public void run() {

    }
}