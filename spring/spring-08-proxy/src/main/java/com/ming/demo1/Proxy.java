package com.ming.demo1;

public class Proxy implements Rent{

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }



    public void rent() {
        host.rent();
        seeHost();
        fare();
        hetong();

    }

    // 看房
    public void seeHost(){
        System.out.println("中介带你去看房");
    }

    // 看房
    public void fare(){
        System.out.println("收中介费");
    }


    // 看房
    public void hetong(){
        System.out.println("签租赁合同");
    }
}
