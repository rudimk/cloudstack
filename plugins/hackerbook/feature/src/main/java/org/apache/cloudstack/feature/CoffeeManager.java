package org.apache.cloudstack.feature;

import org.apache.cloudstack.api.command.CreateCoffeeCmd;

import java.util.Hashtable;

public interface CoffeeManager {
    Hashtable<String, String> createCoffee(CreateCoffeeCmd cmd);
}