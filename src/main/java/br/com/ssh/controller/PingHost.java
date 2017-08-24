package br.com.ssh.controller;

import java.io.IOException;
import java.net.InetAddress;

public class PingHost {
    public boolean isReachable(String host) {
        try {
            return InetAddress.getByName(host).isReachable(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}