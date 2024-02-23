package org.example;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZookeeperCreate {
    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection conn;

    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


    public static void main(String[] args) {

        String path = "/MyFirstZnode";
        byte[] data = "Hello".getBytes(StandardCharsets.UTF_8);

        try {
            conn = new ZookeeperConnection();
            zooKeeper = conn.connect();
            create(path, data);
            conn.close();
        } catch (InterruptedException | IOException | KeeperException e) {
            e.printStackTrace();
        }
    }
}
