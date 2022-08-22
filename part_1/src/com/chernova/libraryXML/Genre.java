package com.chernova.libraryXML;


public enum Genre {

    DETECTIVE(1, "detective"),
    ROMAN(2, "roman"),
    ADVENTURE(3, "adventure"),
    FANTASTIC(4, "fantastic"),
    SCIENCE(5, "science"),
    HISTORY(6, "history"),
    PHILOSOPHY(7, "philosophy");

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




