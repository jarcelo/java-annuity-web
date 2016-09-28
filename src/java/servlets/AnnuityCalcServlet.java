
package servlets;

import business.Annuity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josepharcelo
 */
public class AnnuityCalcServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "/AnnuityResults.jsp";
        String errorMessage = "";
        
        double deposit1, deposit2, rate;
        int term;
        
        Annuity annuity = new Annuity();
        // deposit at beginning of month
        try {
            deposit1 = Double.parseDouble(request.getParameter("amt1"));
            if (deposit1 <= 0) {
                errorMessage += "Beginning deposit must be more than 0. <br>";
            }
            else {
                annuity.setDeposit(deposit1);
            }
        }catch(Exception e) {
            errorMessage += "Deposit error: " + e.getMessage() + "<br>";
        }
        // deposit at end of month
        try {
            deposit2 = Double.parseDouble(request.getParameter("amt1"));
            if (deposit2 <= 0) {
                errorMessage += "Beginning deposit must be more than 0. <br>";
            }
            else {
                annuity.setDeposit(deposit2);
            }
        }catch(Exception e) {
            errorMessage += "Deposit error: " + e.getMessage() + "<br>";
        }

        try {
            rate = Double.parseDouble(request.getParameter("irt"));
            if (rate <= 0) {
                errorMessage += "Interest rate must be more than 0. <br>";
            }
            else {
                annuity.setRate(rate);
            }
        }catch(Exception e) {
            errorMessage += "Rate error: " + e.getMessage() + "<br>";
        }
        
        try {
            term = Integer.parseInt(request.getParameter("term"));
            if (term <= 0) {
                errorMessage += "Beginning deposit must be more than 0. <br>";
            }
            else {
                annuity.setTerm(term);
            }
        }catch(Exception e) {
            errorMessage += "Term error: " + e.getMessage() + "<br>";
        }
        
        if (!errorMessage.isEmpty()) {
            URL = "/AnnuityInput.jsp";
            request.setAttribute("errorMessage", errorMessage);
        }
        
        //request.setAttribute("annuity", annuity);
        
        HttpSession session = request.getSession();
        session.setAttribute("annuity", annuity);
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
