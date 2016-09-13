package edu.csumb.cst438fa16.naelin.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * See: https://jersey.java.net/documentation/latest/test-framework.html
 * https://jersey.java.net/apidocs/latest/jersey/index.html
 */
public class QuestionsAnswersServiceTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(QuestionsAnswersService.class);
	}

	@Test
	public void testQuestionEndsWithQuestionMark() {
		WebTarget webTarget = target("randomquestion"); // arrange
		String theday = webTarget.request().get(String.class); // act
		assertThat(theday, endsWith("?")); // assert
	}

	@Test
	public void testCorrectQuestionAnswerPair() {
		WebTarget webTarget = target("testanswer").queryParam("question", "What is my favourite show?").queryParam("answer", "Wentworth"); // arrange
		String themessage = webTarget.request().get(String.class); // act
		assertThat(themessage, equalTo("'Wentworth' is the correct answer to 'What is my favourite show?'\n")); // assert
	}

	@Test
	public void testQuestionAndEmptyAnswerPair() {
		WebTarget webTarget = target("testanswer").queryParam("question", "What is my favourite show?").queryParam("answer", ""); // arrange
		Response response = webTarget.request().get(); // act
		assertThat(response.getStatus(), equalTo(Response.Status.BAD_REQUEST.getStatusCode())); // assert
	}

	@Test
	public void testEmptyQuestionAndAnswerPair() {
		WebTarget webTarget = target("testanswer").queryParam("question", "").queryParam("answer", "whoami"); // arrange
		Response response = webTarget.request().get(); // act
		assertThat(response.getStatus(), equalTo(Response.Status.BAD_REQUEST.getStatusCode())); // assert
	}
	
	@Test
	public void testEmptyQuestionAndEmptyAnswerPair() {
		WebTarget webTarget = target("testanswer").queryParam("question", "").queryParam("answer", ""); // arrange
		Response response = webTarget.request().get(); // act
		assertThat(response.getStatus(), equalTo(Response.Status.BAD_REQUEST.getStatusCode())); // assert
	}
}