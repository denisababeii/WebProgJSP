function validateForm() {
    var noQuestions = document.forms["quizForm"]["noQuestions"].value;
    var noQuestionsPerPage = document.forms["quizForm"]["noQuestionsPerPage"].value;

    if (noQuestions == "" && noQuestionsPerPage == "") {
        alert("Fields must be filled out");
        return false;
    }

    if (noQuestions == "") {
        alert("First field must be filled out");
        return false;
    }

    if (noQuestionsPerPage == "") {
        alert("Second field must be filled out");
        return false;
    }

    if (isNaN(noQuestions) || noQuestions < 1 || noQuestions > 10) {
        alert("Total number of questions must be a number between 1 and 10");
        return false;
    }

    if (isNaN(noQuestionsPerPage) || noQuestionsPerPage < 1 || noQuestionsPerPage > 10) {
        alert("Number of questions per page must be a number between 1 and 10");
        return false;
    }

    if (noQuestionsPerPage > noQuestions) {
        alert("Number of questions per page must be smaller than total number of questions")
        return false;
    }

    if (noQuestions%noQuestionsPerPage!=0) {
        alert("Invalid number of pages")
        return false;
    }

    return true;
}