package com.cj.module_b;


import com.cj.annotations.bus.EventRegister;
import com.cj.annotations.bus.ModuleEventCenter;

/**
 * Author:chris - jason
 * Date:2019-08-14.
 * Package:com.cj.module_b
 */
@ModuleEventCenter
public class EventCenter_B {

    @EventRegister(type = String.class)
    public String eee = "fefef";

}
