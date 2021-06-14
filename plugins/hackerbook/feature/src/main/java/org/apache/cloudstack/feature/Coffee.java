package org.apache.cloudstack.feature;

import org.apache.cloudstack.api.Identity;
import org.apache.cloudstack.api.InternalIdentity;

public interface Coffee extends InternalIdentity, Identity  {


    enum Size {
        SMALL, MEDIUM, LARGE
    }

    enum Offering {
        Espresso, Cappuccino, Mocha, Latte
    }

    enum CoffeeState {
        Created, Brewing, Brewed, Discarded;
    }

    // Define other enum, constants, events, fsm etc.

    String getName();
    String getDescription();
    // Define other methods
}