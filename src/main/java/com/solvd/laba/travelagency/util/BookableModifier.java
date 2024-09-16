package com.solvd.laba.travelagency.util;

import com.solvd.laba.travelagency.model.booking.Bookable;

@FunctionalInterface
public interface BookableModifier<T extends Bookable> {
    void modify(T bookable);
}
