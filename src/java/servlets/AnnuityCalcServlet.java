
package servlets;

import business.Annuity;
import java.io.IOException;
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
        
        double deposit1 = 0, deposit2 = 0, rate;
        int term;
        
        Annuity annuity = new Annuity();

        try {
            deposit1 = Double.parseDouble(request.getParameter("amt1"));
            if (deposit1 < 0) {
                throw new IllegalArgumentException();
            }
            else {
                annuity.setDepositStartOfMonth(deposit1);
            }
        }catch(IllegalArgumentException e) {
            errorMessage += "Beginning of month input error (Deposit must be at least $0.0). <br>";
        }catch(Exception e) {
            errorMessage += "Beg. of month deposit error. Enter a valid value. <br>";
        }
        
        try {
            deposit2 = Double.parseDouble(request.getParameter("amt2"));
            if (deposit1 == 0 && deposit2 == 0) {
                errorMessage += "Deposit error (Both deposits cannot be zero).<br>";
            }
            if (deposit2 < 0) {
                throw new IllegalArgumentException();
            }
            else {
                annuity.setDepositEndOfMonth(deposit2);
            }
        }catch(IllegalArgumentException e) {
            errorMessage += "End of month input error (Deposit must be at least $0.0). <br>";
        }catch(Exception e) {
            errorMessage += "End of month deposit error. Enter a valid value.<br>";
        }

        try {
            rate = Double.parseDouble(request.getParameter("irt"));
            if (rate <= 0) {
                throw new IllegalArgumentException();
            }
            else {
                annuity.setRate(rate);
            }
        }catch(IllegalArgumentException e){
            errorMessage += "Rate input error (Interest rate must be greater than 0).<br>";
        }catch(Exception e) {
            errorMessage += "Rate input error. Enter a valid value.<br>";
        }
        
        try {
            term = Integer.parseInt(request.getParameter("term"));
            if (term <= 0) {
                throw new IllegalArgumentException();
            }
            else {
                annuity.setTerm(term);
            }
        }catch(IllegalArgumentException e) {
            errorMessage += "Term input error (Term must be greater than 0).<br>";
        }catch(Exception e) {
            errorMessage += "Term input error. Enter a valid value.<br>";
        }
        
        if (!errorMessage.isEmpty()) {
            URL = "/AnnuityInput.jsp";
            request.setAttribute("errorMessage", errorMessage);
        }
                
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
