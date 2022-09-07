package com.ming.demo1;

public class Client {
    public static void main(String[] args) {
        // 房东要出租房子
        Host host = new Host();
        // 代理 中间帮房东出租房子， 代理角色一般有一些附属操作！
        Proxy proxy = new Proxy(host);

        // 你找到中介租房
        proxy.rent();
    }
}
