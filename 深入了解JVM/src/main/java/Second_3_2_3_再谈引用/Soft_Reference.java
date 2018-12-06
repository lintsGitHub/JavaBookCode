package Second_3_2_3_再谈引用;

import java.lang.ref.SoftReference;

public class Soft_Reference {

    public static void main(String[] args) {
        Book book = new Book();
        SoftReference softReference = new SoftReference(book);
        Book softBook = (Book) softReference.get();
        softBook.seyHello();
    }
}
