package com.carSharing.entity;

public enum Cost {

        TEN(10),
        ONE_HUNDRED(100),
        ONE_THOUSAND(1000);

        private final int value;

        Cost(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

