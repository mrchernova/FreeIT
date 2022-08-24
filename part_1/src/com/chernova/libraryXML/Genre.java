package com.chernova.libraryXML;

public enum Genre {
    DETECTIVE(1, "detective"),
    ROMANCE(2, "romance"),
    ADVENTURE(3, "adventure"),
    FANTASY(4, "fantasy"),
    SCIENCE(5, "science"),
    HISTORY(6, "history"),
    PHILOSOPHY(7, "philosophy");

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



