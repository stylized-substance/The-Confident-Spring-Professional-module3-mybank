package org.stylizedsubstance.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.stylizedsubstance.mybank.context.ApplicationConfiguration;
import org.stylizedsubstance.mybank.model.Transaction;
import org.stylizedsubstance.mybank.service.TransactionService;

import java.io.IOException;
import java.util.List;

public class MyBankServlet extends HttpServlet {
    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        this.transactionService = ctx.getBean(TransactionService.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF8");
            List<Transaction> transactions = transactionService.findAll();
            response.getWriter().print(objectMapper.writeValueAsString(transactions));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            int amount = Integer.parseInt(request.getParameter("amount"));
            String reference = request.getParameter("reference");
            Transaction transaction = transactionService.create(amount, reference);
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(objectMapper.writeValueAsString(transaction));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
