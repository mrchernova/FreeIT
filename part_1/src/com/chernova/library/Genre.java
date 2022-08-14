package com.chernova.library;


public enum Genre {
    DETECTIVE(1, "Детектив"),
    ROMAN(2, "Роман"),
    ADVENTURE(3, "Приключение"),
    FANTASTIC(4, "Фантастика"),
    SCIENCE(5, "Наука"),
    HISTORY(6, "История"),
    PHILOSOPHY(7, "Философия");

    int genreId;
    String value;

    Genre(int genreId, String value) {
        this.genreId = genreId;
        this.value = value;
    }

    public static String getGenreByID(int genreId) {

        for (Genre g : Genre.values()) {
            if (g.genreId == genreId) {
                return g.value;
            }
        }
        return "UNKNOWN";

    }


    public static void printGenre() {
        for (Genre g : Genre.values()) {
            System.out.println(g.genreId + ". " + g.value);
        }
    }


}





