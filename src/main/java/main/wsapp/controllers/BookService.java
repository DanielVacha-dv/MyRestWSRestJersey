package main.wsapp.controllers;


import main.wsapp.db.MyDBFake;
import main.wsapp.models.Book;
import main.wsapp.models.Library;
import org.glassfish.jersey.media.multipart.FormDataParam;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bookService")
public class BookService {

    //http://localhost:8080/MyRestWSRestJersey/bookService/addBook?bookName=Elik&bookPages=563 o
//    @POST
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/addBook")
//    public Response insertBook(@FormParam("bookName") final String bookName, @FormParam("bookPages") final int pages) {
////    public Response insertBook(@FormDataParam("") Book book) {
//        Library dbFake = MyDBFake.getDbFake();
//        Book n = new Book();
//        n.setId(dbFake.getNewId());
//        n.setBookPages(pages);
////        n.setBookPages(book.getBookPages());
//        n.setBookName(bookName);
////        n.setBookName(book.getBookName());
//        dbFake.getContent().add(n);
//        return Response.status(200).build();
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/editBook")
//    public Response editBook(@Form Book book){
    public Response editBook(@FormParam("bookIdName") final int bookID,@FormParam("bookName") final String bookName,
                             @FormParam("bookPages") final int bookPages) {
        Library dbFake = MyDBFake.getDbFake();
        Book book1 = dbFake.getContent().stream().filter(el -> el.getId() == bookID).findFirst().orElse(null);
//        Book book1 = dbFake.getContent().stream().filter(el -> el.getId() == book.getId()).findFirst().orElse(null);
        if (book1 != null) {
            book1.setBookPages(bookPages);
//            book1.setBookPages(book.getBookPages());
            book1.setBookName(bookName);
//            book1.setBookName(book.getBookName());
        }
        return Response.status(200).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteBook")
    public Response deleteBook(@QueryParam("bookIdName") final int id) {

        Library dbFake = MyDBFake.getDbFake();
        Book b = dbFake.getContent().stream().filter(el -> el.getId() == id).findFirst().orElse(null);
        if (b != null) {
            dbFake.getContent().remove(b);
        }
        return Response.status(200).build();
    }
//http://localhost:8080/MyRestWSRestJersey/bookService/getAllBook on jersey
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllBook")
    public Response getAllBook() {
        Library dbFake = MyDBFake.getDbFake();
        return Response.status(200).entity(dbFake).build();
    }
}
