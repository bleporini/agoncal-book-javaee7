package org.agoncal.book.javaee7.chapter08.ex01;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookEJBIT {

    // ======================================
    // =             Attributes             =
    // ======================================

    private static EJBContainer ec;
    private static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        ec = EJBContainer.createEJBContainer(properties);
        ctx = ec.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null)
            ctx.close();
        if (ec != null)
            ec.close();
    }

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldCreateABook() throws Exception {

        // Creates an instance of book
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy book");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);

      // Check JNDI dependencies
      assertNotNull(ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter08.ex01.BookEJB"));
      assertNotNull(ctx.lookup("java:global/classes/BookEJB"));

      // Looks up the EJB
        BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter08.ex01.BookEJB");

        // Persists the book to the database
        book = bookEJB.createBook(book);
        assertNotNull("ID should not be null", book.getId());

        // Retrieves all the books from the database
        List<Book> books = bookEJB.findBooks();
        assertNotNull(books);
    }
}