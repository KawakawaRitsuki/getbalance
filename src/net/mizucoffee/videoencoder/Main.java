package net.mizucoffee.videoencoder;

import net.mizucoffee.wiimote4j.WiiBalanceBoardManager;
import net.mizucoffee.wiimote4j.device.DeviceConnector;
import net.mizucoffee.wiimote4j.device.WiiBalanceBoard;

public class Main {

    private static WiiBalanceBoard wbb;

    public static void main(String[] args) {

        DeviceConnector wiimoteDC = new DeviceConnector();
        wiimoteDC.connect(0, DeviceConnector.WIIBALANCE_BOARD);

        wbb = new WiiBalanceBoard(wiimoteDC.getDevInfo());

        WiiBalanceBoardManager wbbm = new WiiBalanceBoardManager();
        wbb.setInputReportListener(wbbm);
        wbb.setPlayerID(true);
        wbb.setReportMode((byte) 0x32);

        wbbm.setOnBoardDataChangedListener((int rf, int rb, int lf, int lb) -> {
            System.out.println((lf+lb) + ","+(rf+rb));
        });

    }
}
