package org.example;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        final CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(ZookeeperConst.CONNECT_STRING)
                .sessionTimeoutMs(ZookeeperConst.SESSION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("").build();

        curatorFramework.start();

        System.out.println(curatorFramework.getState());
//        Stat stat = new Stat();

//        final byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/runoob");

        curatorFramework.close();
    }
}
