package edu.csumb.cst438fa16.naelin.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import edu.csumb.cst438fa16.naelin.QuestionsAnswers;

/**
 * REST service that greets requests.
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */

@Path("/")
public class QuestionsAnswersService {
    @GET
    @Path("/randomquestion")
    public String randomQuestion() {
    	QuestionsAnswers qa = new QuestionsAnswers();
    	return qa.getRandomQuestion();
    }

    @GET
    @Path("/testanswer")
    public Response testQuestionAnswer(@QueryParam("question") String question, @QueryParam("answer") String answer) {
   	
    	if (question == null || question.isEmpty() || answer == null || answer.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
        	QuestionsAnswers qa = new QuestionsAnswers();
        	if(qa.testAnswer(question, answer)) {
                return Response.ok("'" + answer + "' is the correct answer to '" + question + "'\n").build();
        	} else {
                return Response.ok("Nope").build();
        	}
        		
        }
    }
}