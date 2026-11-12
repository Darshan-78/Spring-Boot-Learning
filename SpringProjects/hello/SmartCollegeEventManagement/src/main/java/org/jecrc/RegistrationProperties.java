package org.jecrc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegistrationProperties {

    @Value("${registration.enabled}")
    private boolean enabled;

    @Value("${registration.max-participants}")
    private int maxParticipants;

    @Value("${registration.fee}")
    private int fee;

    @Value("${registration.discount}")
    private int discount;

    @Value("${registration.last-date}")
    private String lastDate;

    public boolean isEnabled() {
        return enabled;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public int getFee() {
        return fee;
    }

    public int getDiscount() {
        return discount;
    }

    public String getLastDate() {
        return lastDate;
    }
}