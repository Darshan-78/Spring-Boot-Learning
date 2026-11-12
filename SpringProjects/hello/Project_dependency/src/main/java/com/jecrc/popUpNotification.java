
package com.jecrc;

import org.springframework.stereotype.Component;

@Component("popUpNotification")
public class popUpNotification implements Notification {

    @Override
    public void sendNotification() {
        System.out.println("Popup notification displayed!");
    }
}
