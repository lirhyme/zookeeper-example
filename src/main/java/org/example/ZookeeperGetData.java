package org.example;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperGetData {
    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection conn;

    public static Stat exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }

    public static byte[] getData(String path) throws KeeperException, InterruptedException {
        return zooKeeper.getData(path, true, null);
    }



    public static void main(String[] args) {

        String path = "/MyFirstZnode";

        try {
            conn = new ZookeeperConnection();
            zooKeeper = conn.connect();
            final byte[] data = getData(path);
            System.out.println(new String(data));
            conn.close();
        } catch (InterruptedException | IOException | KeeperException e) {
            e.printStackTrace();
        }
    }
}
