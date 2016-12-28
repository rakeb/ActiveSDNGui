/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.utility;

import activesdngui.controller.EventSpecificationController;
import activesdngui.model.Action;
import activesdngui.model.Event;
import activesdngui.model.Pattern;
import activesdngui.model.Signature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mislam7
 */
public class Utilities {

    public static void pirntArray(Object array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void pirntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printController(EventSpecificationController controller) {
        List<Event> events = controller.getEvents();
        Pattern pattern = controller.getPattern();
        List<Action> actions = controller.getActions();

        //print events
        System.out.println("\nprinting events: ");
        for (Event event : events) {
            System.out.println("Event name: " + event.getName());
            HashMap<Integer, Signature> signatures = event.getSignatures();
            List<Integer> ids = new ArrayList<>(signatures.keySet());
            Collections.sort(ids);

            for (Integer id : ids) {
                Signature signature = signatures.get(id);
                HashMap<String, Object> fields = signature.getFields();
                List<String> fieldNames = new ArrayList<>(fields.keySet());
                for (String fieldName : fieldNames) {
                    System.out.println("Filed Name: " + fieldName + "Field value: " + fields.get(fieldName));
                }
            }
        }

        //print patterns
        if (pattern != null) {
            System.out.println("\nprinting patterns:");
            HashMap<String, Object> fields = pattern.getFields();
            List<String> fieldNames = new ArrayList<>(fields.keySet());

            for (String fieldName : fieldNames) {
                System.out.println("Filed Name: " + fieldName + "Field value: " + fields.get(fieldName));
            }
        }

        //print actions
        System.out.println("\nprinting actions:");
        for (Action action : actions) {
            HashMap<String, Object> fields = action.getFields();

            List<String> fieldNames = new ArrayList<>(fields.keySet());

            for (String fieldName : fieldNames) {
                System.out.println("Filed Name: " + fieldName + "Field value: " + fields.get(fieldName));
            }
        }
    }
}
