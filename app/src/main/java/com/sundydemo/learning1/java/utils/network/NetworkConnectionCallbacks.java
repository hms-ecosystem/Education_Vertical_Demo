package com.sundydemo.learning1.java.utils.network;


/**
 * @since 2020
 * @author Huawei DTSE USA
 */
public interface NetworkConnectionCallbacks {
    /**
     * On net connected.
     */
    void onNetConnected();

    /**
     * On net disconnected.
     */
    void onNetDisconnected();
}
