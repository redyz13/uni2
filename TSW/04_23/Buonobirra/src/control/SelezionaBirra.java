package control;

import model.EspertoBirra;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelezionaBirra")
public class SelezionaBirra extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String colore = req.getParameter("color");
        List<String> risultato = EspertoBirra.getBirreBuone(colore);

        req.setAttribute("consigli", risultato);
        RequestDispatcher view = req.getRequestDispatcher("/pages/risultato.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
