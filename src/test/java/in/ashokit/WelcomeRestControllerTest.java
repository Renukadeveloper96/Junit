package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.controller.WelcomeRestController;
import in.ashokit.service.WelcomeService;
import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

@WebMvcTest(value=WelcomeRestController.class)//uses for  our target class
public class WelcomeRestControllerTest {

	@MockBean
	private WelcomeService welcomeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGreet() throws Exception {
	when(welcomeService.getGreetMsg()).thenReturn("Good Luck..!!");
	MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/greet");
	MvcResult andReturn = mockMvc.perform(reqBuilder).andReturn();
	MockHttpServletResponse response =andReturn.getResponse();
	int status = response.getStatus();
	assertEquals(200, status);
	}
	@Test
	public void testWelcome() throws Exception {
		when(welcomeService.getWelcomeMsg()).thenReturn("Good Evening");
	
		MockHttpServletRequestBuilder requestBuilder=
				MockMvcRequestBuilders.get("/welcome");
	MvcResult result=mockMvc.perform(requestBuilder).andReturn();
	MockHttpServletResponse response=result.getResponse();
	int status=response.getStatus();
	assertEquals(200,status);
	}
	
}
