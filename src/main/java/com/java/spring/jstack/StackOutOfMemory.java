package com.java.spring.jstack;

import org.springframework.stereotype.Service;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/10<p>
// -------------------------------------------------------
@Service
public class StackOutOfMemory {
    public static int count = 1;

    public void noStop() {
        while (true) {
        }
    }

    public void newThread() {
        while (true) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    System.out.println("已创建第" + count++ + "个线程");
                    noStop();
                }
            });
            t.start();
        }

    }
}
