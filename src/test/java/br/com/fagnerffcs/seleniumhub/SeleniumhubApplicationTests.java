package br.com.fagnerffcs.seleniumhub;

import br.com.fagnerffcs.seleniumhub.pages.ConsultaPublicaPage;
import br.com.fagnerffcs.seleniumhub.pages.LoginPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumhubApplicationTests {

	@Test
	public void testarConsultaPublicaComSucesso() throws MalformedURLException {
		ConsultaPublicaPage consulta = new ConsultaPublicaPage();
		assertEquals(true, consulta.consultaPublicaLocalChrome());
	}

	@Test
	public void testarLoginComSucesso() throws MalformedURLException {
		LoginPage loginPage = new LoginPage();
		assertEquals(true, loginPage.consultaPublicaLocalChrome());
	}

}
