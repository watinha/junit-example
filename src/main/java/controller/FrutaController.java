package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FrutaModel;

@WebServlet(urlPatterns={"/fruta"})
public class FrutaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FrutaModel model = new FrutaModel();

    public void doGet (HttpServletRequest req, HttpServletResponse res) {
        try {
            List <String> lista = this.model.get();
            req.setAttribute("list", lista);
            req.getRequestDispatcher("/WEB-INF/fruta/list.jsp")
               .forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost (HttpServletRequest req, HttpServletResponse res) {
        try {
            this.model.insert(req.getParameter("nome"));
            res.sendRedirect("fruta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setModel (FrutaModel model) { this.model = model; }
}
