package com.company;

import javax.crypto.spec.PSource;

public class Main {

    public static void main(String[] args) {
        Author mas[] = new Author[2];
        mas[0] = new Author("virt","lgp@mail",'m');
        mas[1] = new Author("got","leel@mail",'f');
        Book book = new Book("Vita",mas,123.33);
        System.out.println(book.toString());
        System.out.println(book.getAuthorNames());
    }
}
