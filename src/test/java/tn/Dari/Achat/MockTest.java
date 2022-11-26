package tn.Dari.Achat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class MockTest {

	
	@Autowired
	private MockMvc mockMvc;

	public void SellAddControllerTEst_Should_Retun_STATUS_OK() throws Exception {
		this.mockMvc.perform(get("http://localhost:8090/Achat/All")).andDo(print()).andExpect(status().isOk());
		//.andExpect(content().string(containsString("TUNIS")))
}
}