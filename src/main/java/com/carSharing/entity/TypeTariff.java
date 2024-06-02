package com.carSharing.entity;

public enum TypeTariff {
    F0("24"),
    F1("8:00-19:00 - LUN/VEN"),
    F2F3("8:00-19:00 LUN/DOM");

    private String description;

    TypeTariff(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static TypeTariff fromString(String value) {
        for (TypeTariff typeTariff : TypeTariff.values()) {
            if (typeTariff.name().equals(value)) {
                return typeTariff;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    public static String getDescriptionByValue(String value) {
        return fromString(value).getDescription();
    }
}