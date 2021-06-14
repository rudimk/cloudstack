package org.apache.cloudstack.feature;

import org.apache.cloudstack.api.command.CreateCoffeeCmd;
import org.apache.cloudstack.api.command.ListCoffeesCmd;

import java.util.Hashtable;
import java.util.List;

public interface CoffeeManager {
    Hashtable<String, String> createCoffee(CreateCoffeeCmd cmd);
    List<Coffee> listCoffees(ListCoffeesCmd cmd);
}