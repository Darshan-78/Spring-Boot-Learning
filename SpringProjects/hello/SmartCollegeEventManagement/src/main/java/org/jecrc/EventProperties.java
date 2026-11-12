package org.jecrc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventProperties {

    @Value("${event.name}")
    private String eventName;

    @Value("${event.category}")
    private String category;

    @Value("${event.venue}")
    private String venue;

    @Value("${event.date}")
    private String date;

    @Value("${event.organizer}")
    private String organizer;

    public String getEventName() {
        return eventName;
    }

    public String getCategory() {
        return category;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getOrganizer() {
        return organizer;
    }
}
