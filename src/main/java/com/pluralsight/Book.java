package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public void checkOut(String name){
        isCheckedOut = true;
        checkedOutTo = name;

    }

    public void checkIn(){
        isCheckedOut = false;
        checkedOutTo = "";
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return id + ": " + title + "(" + isbn + ") - " + (isCheckedOut ? "Checked out to " + checkedOutTo: "Available");
    }

}




