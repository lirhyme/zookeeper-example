package org.example;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZookeeperDelete {
    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection conn;

    public static Stat exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }

    public static void delete(String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path, exists(path).getVersion());
    }


    public static void main(String[] args) {

        String path = "/MyFirstZnode";
        byte[] data = "Hello".getBytes(StandardCharsets.UTF_8);

        try {
            conn = new ZookeeperConnection();
            zooKeeper = conn.connect();
            delete(path);
            conn.close();
        } catch (InterruptedException | IOException | KeeperException e) {
            e.printStackTrace();
        }
    }
}
