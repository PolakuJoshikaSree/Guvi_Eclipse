package com.library.service;

import java.util.*;
import com.library.model.*;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addMember(Member member) { members.add(member); }

    public void borrowBook(String bookId, String memberId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println(memberId + " borrowed " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available!");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                book.setAvailable(true);
                System.out.println(book.getTitle() + " returned successfully.");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void listBooks() {
        System.out.println("\nBooks in Library:");
        books.forEach(System.out::println);
    }
}
