package com.example.taxidrivers.util;

import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PredicateUtil {
    private final List<Predicate> predicates = new ArrayList<>();

    // Factory method to create an instance of PredicateUtil
    public static PredicateUtil builder() {
        return new PredicateUtil();
    }

    // Method to add a Predicate directly
    public <T> PredicateUtil add(T object, Function<T, Predicate> function) {
        predicates.add(function.apply(object));
        return this;
    }

    // Method to add a Predicate with null safety
    public <T> PredicateUtil addNullSafety(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    // Method to build the Predicate array
    public Predicate[] build() {
        return predicates.toArray(new Predicate[0]);
    }

    // Utility method to apply a LIKE pattern
    public static String applyLikePattern(String key) {
        return "%" + key + "%";
    }
}
