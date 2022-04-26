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

public class QuizController extends HttpServlet {
    public QuizController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int correct = 0;
        int incorrect = 0;
        var manager = new DBManager();
        String[] questionIds = request.getParameterValues("questionId");
        for (String questionId : questionIds) {
            Question question = manager.getQuestionById(Integer.parseInt(questionId));
            var answer = question.getAnswer();
            var param = request.getParameter("question_"+questionId);
            if(question.getAnswer().equals(request.getParameter("question_"+questionId)))
                correct+=1;
            else
                incorrect+=1;
        }
        request.setAttribute("correct", correct);
        request.setAttribute("incorrect",incorrect);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        var bestResult = manager.getBestResult(user.getUsername());
        if(correct > bestResult) {
            manager.setBestResult(user.getUsername(), correct);
            request.setAttribute("bestResult",correct);
        }
        else
            request.setAttribute("bestResult",bestResult);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

}
