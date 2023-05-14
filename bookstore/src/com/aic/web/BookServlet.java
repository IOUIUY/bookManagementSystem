package com.aic.web;

import com.aic.pojo.Book;
import com.aic.service.BookService;
import com.aic.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    protected void showAllBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.showAllBooks();
        HttpSession session = req.getSession();
        session.setAttribute("books",books);
        req.getRequestDispatcher("/pages/bookManagement/bookManagement.jsp").forward(req,resp);
    }

    protected void queryBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String way = req.getParameter("way");
        String searchBook = req.getParameter("searchBook");
        List<Book> books;
        if("bookName".equals(way)) books = bookService.findBooksByName(searchBook);
        else books = bookService.findBooksByAuthor(searchBook);
        HttpSession session = req.getSession();
        session.setAttribute("books",books);
        req.getRequestDispatcher("/pages/bookManagement/bookManagement.jsp").forward(req,resp);
    }
}
