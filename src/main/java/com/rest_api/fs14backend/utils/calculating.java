package com.rest_api.fs14backend.utils;

public class calculating {
    public int getRandomRating(int min, int max) {
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }
}
