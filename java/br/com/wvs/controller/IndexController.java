package br.com.wvs.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.wvs.seguranca.Open;

@Controller
public class IndexController {
	
	@Path("/")
	public void index() {};

}
