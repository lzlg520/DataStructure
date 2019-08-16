package com.lzlg.interview.j2ee;

public class J2EENameDescribe {
    public static void main(String[] args) {
        // 1.J2EE是什么？
        /**
         * J2EE是Sun公司提出的多层，分布式，基于组件的企业级应用模型。
         * 在此应用系统中，按照功能划分为不同的组件，这些组件可在不同的计算机上，
         * 并且处于相应的层次中。所属层次包括客户层组件，Web层和组件，
         * Business层和组件，企业信息系统EIS层。
         */
        // 2.JNDI，JMS，JTA，JAF，RMI名称解释：
        /**
         * JNDI：Java Naming & Directory Interface，Java命名目录服务。
         *      主要提供一个目录系统，让其他各地的应用程序在其上面留下自己的索引。
         *      从而满足快速查找和定位分布式应用程序的功能。
         *
         * JMS：Java Message Service，Java消息服务，主要实现各个应用程序之间的通信，
         *      包括点对点和广播。
         *
         * JTA：Java Transaction API，Java事务服务，提供各种分布式事务服务，
         *      应用程序只需调用其提供的接口即可。
         *
         * JAF：Java Action FrameWork，Java安全认证框架，提供一些安全控制方面的框架，
         *      让开发者通过各种部署和自定义实现自己的个性安全控制策略。
         *
         * RMI：Remote Method Interface，远程方法调用。
         */
    }
}
