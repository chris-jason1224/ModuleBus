package com.cj.module_a;

import com.cj.annotations.bus.EventRegister;
import com.cj.annotations.bus.ModuleEventCenter;

/**
 * Author:chris - jason
 * Date:2019-08-13.
 * Package:com.cj.module_a
 */
@ModuleEventCenter
public class EventCenter_A{

    @EventRegister(classType = String.class)
    private String event_1 = "event_11111";

    @EventRegister(classType = Integer.class)
    private String event_2 = "event_2222222gygtf";


}
