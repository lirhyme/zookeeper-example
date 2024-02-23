package org.example;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperConnection {

    private ZooKeeper zooKeeper;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public ZooKeeper connect () throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper(ZookeeperConst.CONNECT_STRING, ZookeeperConst.SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    countDownLatch.countDown();
                }

            }
        });
        countDownLatch.await();
        return zooKeeper;
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
