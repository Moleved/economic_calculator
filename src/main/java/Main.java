import connection.TCPServer;
import entity.AbsoluteLiquidityEntity;
import entity.ApplicationEntity;
import entity.CurrentLiquidityEntity;
import entity.LiquidityEntity;
import processors.AbsoluteLiquidityProcessor;
import processors.CurrentLiquidityProcessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(final String[] args) throws Exception {
        TCPServer server = new TCPServer(9876);
        new Thread(server).start();
    }
}