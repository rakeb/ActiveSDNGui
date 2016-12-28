/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.controller;

import activesdngui.model.Action;
import activesdngui.model.Event;
import activesdngui.model.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mislam7
 */
public class EventSpecificationController {
    private List<Event> events;
    private Pattern pattern;
    private List<Action> actions;

    public EventSpecificationController() {
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
