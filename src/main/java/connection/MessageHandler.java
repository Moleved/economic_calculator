package connection;

import entity.AbsoluteLiquidityEntity;
import entity.ApplicationEntity;
import entity.CurrentLiquidityEntity;
import entity.ProfitabilityEntity;
import processors.AbsoluteLiquidityProcessor;
import processors.CurrentLiquidityProcessor;
import processors.ProfitabilityProcessor;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageHandler {
    private HashMap<String, String> values;
    private String object;
    private String method;
    private Long appId;

    public MessageHandler(MessageParser parser) {
        this.method = parser.getMethod();
        this.values = parser.getValues();
        this.object = parser.getObject();
        this.appId = parser.getAppId();
    }

    public String handle() {
        if (method.equals("POST")) return setObject();
        else if (method.equals("GET")) return sendList();
        return "";
    }

    /* POST logic */

    private String setObject() {
        if (object.equals("AbsoluteLiquidity")) setAbsoluteLiquidity();
        else if (object.equals("CurrentLiquidity")) setCurrentLiquidity();
        else if (object.equals("Profitability")) setProfitability();

        return "200";
    }

    private void setAbsoluteLiquidity() {
        AbsoluteLiquidityEntity entity = new AbsoluteLiquidityEntity();

        entity.setFunds(Double.parseDouble(values.get("funds")));
        entity.setShortFinancialInvestments(Double.parseDouble(values.get("shortFinancialInvestments")));
        entity.setShortLiabilities(Double.parseDouble(values.get("shortLiabilities")));

        new AbsoluteLiquidityProcessor(appId, entity).perform();
    }

    private void setCurrentLiquidity() {
        CurrentLiquidityEntity entity = new CurrentLiquidityEntity();

        entity.setRevolvingAssets(Double.parseDouble(values.get("revolvingAssets")));
        entity.setShortLiabilities(Double.parseDouble(values.get("shortLiabilities")));

        new CurrentLiquidityProcessor(appId, entity).perform();
    }

    private void setProfitability() {
        ProfitabilityEntity entity = new ProfitabilityEntity();

        entity.setTotalProductSalesCosts(Double.parseDouble(values.get("totalProductSalesCosts")));
        entity.setProfitFromAllActivities(Double.parseDouble(values.get("profitFromAllActivities")));

        new ProfitabilityProcessor(appId, entity).perform();
    }

    /* GET logic */

    private String sendList() {
        String response = "404";
        if (object.equals("AbsoluteLiquidity")) response = listAbsoluteLiquidity();
        else if (object.equals("CurrentLiquidity")) response = listCurrentLiquidity();
        else if (object.equals("Profitability")) response = listProfitability();
        return response;
    }

    private String listAbsoluteLiquidity() {
        ArrayList<AbsoluteLiquidityEntity> list = AbsoluteLiquidityEntity.getAll();
        String result = "AbsoluteLiquidityEntity>";

        for (AbsoluteLiquidityEntity ent : list) {
            result += (ent.toStr() + ";");
        }

        return result + "break";
    }

    private String listCurrentLiquidity() {
        ArrayList<CurrentLiquidityEntity> list = CurrentLiquidityEntity.getAll();
        String result = "CurrentLiquidityEntity>";

        for (CurrentLiquidityEntity ent : list) {
            result += (ent.toStr() + ";");
        }

        return result + "break";
    }

    private String listProfitability() {
        ArrayList<ProfitabilityEntity> list = ProfitabilityEntity.getAll();
        String result = "ProfitabilityEntity>";

        for (ProfitabilityEntity ent : list) {
            result += (ent.toStr() + ";");
        }

        return result + "break";
    }
}
