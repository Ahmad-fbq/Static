package com.example;

public class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}

class Main {
    public static void main(String[] args) {
        // Initializing de books array!!!!!!!
        Book[] books = {
            new Book("Crime and Punishment", 1866),
            new Book("Introduction to Flight 9th Ed.", 2021),
            new Book("The Five Dysfunctions of a Team", 2002),
            new Book("A Theory of Justice", 1971),
            new Book("Emotional Intelligence: Why it Can Matter More Than IQ", 1995),
            new Book("Mind Whisperring: A New Map to Freedom from Self-Defeating Emotional Habits", 2013),
            new Book("The Little Prince", 1943),
            new Book("Frames of Mind: The Theory of Multiple Intelligence", 1983),
            new Book("Introduction to Ancient Philosophy", 1947),
            new Book("Clean Architecture: A Craftsman's Guide to Software Structre and Design", 2017),
            new Book("Functional Design: Principles, Patterns, and Practices", 2023),
            new Book("Introduction to Software Project Managment", 2013),
            new Book("The Conditions of The Renaissance", 1986),
            new Book("Contemporary European Philosophy", 1961),
            new Book("Clean Agile", 2019),
            new Book("Clean Code: A Handbook of Agile Software Craftsmanship", 2009),
        };

        // Sorting deee books array (bubble sort btw) O(nlog(n))--Because we're professionals and we don't use Arrays.sort() xD
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

        // Printing for searching reasons only!! Online stalking our Array X)
        System.out.println("Books sorted by year:");
        for (Book book : books) {
            System.out.println("\n" + book.getTitle() + " - " + book.getYear());
        }

        // Testing our BinarySearch Algorithm :O
        int searchYear = 2023;
        int result = binarySearch(books, searchYear);

        if (result != -1) {
            System.out.println("\nBook from year: " + searchYear +  " was found: " + books[result].getTitle());
        } else {
            System.out.println("\nBook not found from year: " + searchYear);
        }
    }

    public static int binarySearch(Book[] books, int targetYear) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentYear = books[mid].getYear();
            if (currentYear == targetYear) {
                return mid;
            }

            if (currentYear < targetYear) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        // If you reach here, thx for reading. JK the element was not found :(
        return -1;
    }
}
