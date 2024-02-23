package org.example;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZookeeperExists {
    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection conn;

    public static Stat exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }


    public static void main(String[] args) {

        String path = "/MyFirstZnode";

        try {
            conn = new ZookeeperConnection();
            zooKeeper = conn.connect();
            final Stat stat = exists(path);
            if (stat != null) {
                System.out.println("Node exists and the node version is " + stat.getVersion());
            } else {
                System.out.println("Node does not exists");
            }
            conn.close();
        } catch (InterruptedException | IOException | KeeperException e) {
            e.printStackTrace();
        }
    }
}
