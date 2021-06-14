package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-08 16:13
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

/**
 * 假设有三个服务器权重配置如下：
 * server A  weight = 4 ;
 * server B  weight = 3 ;
 * server C  weight = 2 ;
 */
        Node serverA = new Node("serverA", 4);
        Node serverB = new Node("serverB", 3);
        Node serverC = new Node("serverC", 2);

        SmoothWeightedRoundRobin smoothWeightedRoundRobin = new SmoothWeightedRoundRobin(serverB, serverC,serverA);
        for (int i = 0; i < 9; i++) {
            Node i1 = smoothWeightedRoundRobin.select();
            System.out.println(i1.getServerName());
        }
    }
}

class Node {
    private final int weight;  // 初始权重 （保持不变）
    private final String serverName; // 服务名
    private int currentWeight; // 当前权重

    public Node(String serverName, int weight) {
        this.weight = weight;
        this.serverName = serverName;
        this.currentWeight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getServerName() {
        return serverName;
    }
}

class SmoothWeightedRoundRobin {
    private volatile List<Node> nodeList = new ArrayList<>(); // 保存权重
    private ReentrantLock lock = new ReentrantLock();

    public SmoothWeightedRoundRobin(Node... nodes) {
        for (Node node : nodes) {
            nodeList.add(node);
        }
    }

    public Node select() {
        try {
            lock.lock();
            return this.selectInner();
        } finally {
            lock.unlock();
        }
    }

    private Node selectInner() {
        int totalWeight = 0;
        Node maxNode = null;
        int maxWeight = 0;

        for (int i = 0; i < nodeList.size(); i++) {
            Node n = nodeList.get(i);
            totalWeight += n.getWeight();
            // 每个节点的当前权重+原始的权重
            n.setCurrentWeight(n.getCurrentWeight() + n.getWeight());
            // 保存当前权重最大的节点，找到当前权重最大的节点
            if (maxNode == null || maxWeight < n.getCurrentWeight()) {
                maxNode = n;
                maxWeight = n.getCurrentWeight();
            }
        }
        // 被选中的节点权重减掉总权重
        maxNode.setCurrentWeight(maxNode.getCurrentWeight() - totalWeight);
        return maxNode;

        
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            // sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            // 当前系统时间
            System.out.println("格式化后的日期为:" + sdf.format(new Date()));
        }
    }
}


