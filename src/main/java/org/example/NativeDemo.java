package org.example;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class NativeDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        final ZookeeperConnection conn = new ZookeeperConnection();
        final ZooKeeper zooKeeper = conn.connect();
        System.out.println(zooKeeper);
        conn.close();
    }
}
