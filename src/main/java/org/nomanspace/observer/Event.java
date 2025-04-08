package org.nomanspace.observer;

public class Event {
    //класс который каким-то образом содержит в себе информацию о проведенных операциях, кто куда сходил
    //и что седлал
    private String eventType; // Тип события (например, "MOVE", "EAT")
    private Object data; // Дополнительные данные (например, сущность, которая изменилась)

    public Event(String eventType, Object data) {
        this.eventType = eventType;
        this.data = data;
    }

    public String getEventType() {
        return eventType;
    }

    public Object getData() {
        return data;
    }
}
