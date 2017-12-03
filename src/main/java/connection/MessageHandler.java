package connection;

import entity.AbsoluteLiquidityEntity;
import entity.ApplicationEntity;
import entity.CurrentLiquidityEntity;
import entity.ProfitabilityEntity;
import processors.AbsoluteLiquidityProcessor;
import processors.CurrentLiquidityProcessor;

import java.util.HashMap;

public class MessageHandler {
    private HashMap<String, String> values;
    private String object;
    private String method;
    private int appId;

    public MessageHandler(MessageParser parser) {
        this.method = parser.getMethod();
        this.values = parser.getValues();
        this.object = parser.getObject();
        this.appId = parser.getAppId();

        handle();
    }

    public void handle() {
        if (method == "POST") setObject();
        else if (method == "GET") sendList();
    }

    /* POST logic */

    private void setObject() {
        if (object == "AbsoluteLiquidity") setAbsoluteLiquidity();
        else if (object == "CurrentLiquidity") setCurrentLiquidity();
        else if (object == "Profitability") setProfitability();

        TCPServer.sendMessage("OK");
    }

    private void setAbsoluteLiquidity() {
        AbsoluteLiquidityEntity entity = new AbsoluteLiquidityEntity();

        entity.setFunds(Double.parseDouble(values.get("funds")));
        entity.setShortFinancialInvestments(Double.parseDouble(values.get("shortFinancialInvestments")));

        new AbsoluteLiquidityProcessor(appId, entity);
    }

    private void setCurrentLiquidity() {
        CurrentLiquidityEntity entity = new CurrentLiquidityEntity();

        entity.setRevolvingAssets(Double.parseDouble(values.get("revolvingAssets")));

        new CurrentLiquidityProcessor(appId, entity);
    }

    private void setProfitability() {
        ProfitabilityEntity entity = new ProfitabilityEntity();

        entity.setTotalProductSalesCosts(Double.parseDouble(values.get("totalProductSalesCosts")));
        entity.setProfitFromAllActivities(Double.parseDouble(values.get("profitFromAllActivities")));

        entity.save();
    }

    /* GET logic */

    private void sendList() {

    }
}
