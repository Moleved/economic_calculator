package connection;

import entity.AbsoluteLiquidityEntity;
import entity.ApplicationEntity;
import entity.CurrentLiquidityEntity;
import entity.ProfitabilityEntity;

import java.util.HashMap;

public class MessageHandler {
    private MessageParser parser;

    public MessageHandler(MessageParser parser) {
        this.parser = parser;

        handle();
    }

    public void handle() {
        String method = parser.getMethod();

        if (method == "POST") saveObject();
        else if (method == "GET") sendList();
    }

    /* POST logic */

    private ApplicationEntity getApplicationById(String id) {
        Integer appId = Integer.parseInt(id);

        ApplicationEntity entity = new ApplicationEntity();
        return (ApplicationEntity) entity.getById(appId);
    }

    private void saveObject() {
        String object = parser.getObject();

        if (object == "AbsoluteLiquidity") saveAbsoluteLiquidity();
        else if (object == "CurrentLiquidity") saveCurrentLiquidity();
        else if (object == "Profitability") saveProfitability();

        TCPServer.sendMessage("OK");
    }

    private void saveAbsoluteLiquidity() {
        HashMap<String, String> values = parser.getValues();
        AbsoluteLiquidityEntity entity = new AbsoluteLiquidityEntity();

        entity.setFunds(Double.parseDouble(values.get("funds")));
        entity.setShortFinancialInvestments(Double.parseDouble(values.get("shortFinancialInvestments")));

        entity.save();
    }

    private void saveCurrentLiquidity() {
        HashMap<String, String> values = parser.getValues();
        CurrentLiquidityEntity entity = new CurrentLiquidityEntity();

        entity.setRevolvingAssets(Double.parseDouble(values.get("revolvingAssets")));

        entity.save();
    }

    private void saveProfitability() {
        HashMap<String, String> values = parser.getValues();
        ProfitabilityEntity entity = new ProfitabilityEntity();

        entity.setTotalProductSalesCosts(Double.parseDouble(values.get("totalProductSalesCosts")));
        entity.setProfitFromAllActivities(Double.parseDouble(values.get("profitFromAllActivities")));

        entity.save();
    }

    /* GET logic */

    private void sendList() {

    }
}
