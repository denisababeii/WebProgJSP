package controller;

import domain.Question;
import model.DBManager;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionController extends HttpServlet {
    public QuestionController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        int noQuestions = Integer.parseInt(request.getParameter("noQuestions"));
        int noQuestionsPerPage = Integer.parseInt(request.getParameter("noQuestionsPerPage"));

        DBManager manager = new DBManager();
        ArrayList<Question> questions = manager.getQuestions(noQuestions);
        request.setAttribute("questions",questions);
        request.setAttribute("noQuestionsPerPage",noQuestionsPerPage);
        request.setAttribute("currentPageIndex",0);
        RequestDispatcher rd = request.getRequestDispatcher("/quiz.jsp");
        rd.forward(request,response);
    }
}
