package com.example.testall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Thai {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    List<Item> items;

    public static List<Thai> thais = new ArrayList<>();
    public static List<Item> itemss = new ArrayList<>();
    static {
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        itemss.add(item1);
        itemss.add(item2);
        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com", itemss));
        thais.add(new Thai(2L, "thái", "vũ ", "thai1@gmamil.com", itemss));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(1L, "thái", "vũ ", "thai1@gmamil.com"));
//        thais.add(new Thai(2L, "quỳnh", "văn", "thai1@gmamil.com"));
//        thais.add(new Thai(3L, "anh", "xuân", "thai1@gmamil.com"));
//        thais.add(new Thai(4L, "an", "ngô", "thai1@gmamil.com"));
//        thais.add(new Thai(5L, "an", "ngô", "thai1@gmamil.com"));
//        thais.add(new Thai(6L, "an", "ngô", "thai1@gmamil.com"));
//        thais.add(new Thai(7L, "an", "ngô", "thai1@gmamil.com"));
//        thais.add(new Thai(8L, "an", "ngô", "thai1@gmamil.com"));
//        thais.add(new Thai(9L, "an", "ngô", "thai1@gmamil.com"));
    }

    public static void setItems(List<Item> items) {
        Thai.itemss = items;
    }

    public List<Item> getItems() {
        return itemss;
    }

    public static List<Thai> getListThai(){
        return thais;
    }
}
