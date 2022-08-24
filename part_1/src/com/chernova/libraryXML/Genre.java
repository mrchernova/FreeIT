package com.chernova.libraryXML;

public enum Genre {
    DETECTIVE(1, "Detective"),
    ROMANCE(2, "Romance"),
    ADVENTURE(3, "Adventure"),
    FANTASY(4, "Fantasy"),
    SCIENCE(5, "Science"),
    HISTORY(6, "History"),
    PHILOSOPHY(7, "Philosophy");

    int genreId;
    String value;

    Genre(int genreId, String value) {
        this.genreId = genreId;
        this.value = value;
    }

    public static void printGenre() {
        for (Genre g : Genre.values()) {
            System.out.println(g.genreId + ". " + g.value);
        }
    }
}



