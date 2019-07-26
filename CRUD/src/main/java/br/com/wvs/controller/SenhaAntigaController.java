package br.com.wvs.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.wvs.dao.SqlServer;
import br.com.wvs.dao.UsuarioDao;
import br.com.wvs.model.SenhaAntiga;

import javax.inject.Inject;
import java.util.List;

@Controller
public class SenhaAntigaController {

    private UsuarioDao antigaDao;
    private Result result;

    @Inject
    public SenhaAntigaController(UsuarioDao antigaDao, Result result) {
        this.antigaDao = antigaDao;
        this.result = result;
    }

    public SenhaAntigaController () { }

    public void salvaSenhaAntiga (SenhaAntiga senhaAntiga){
        antigaDao.salvaSenhaAntiga(senhaAntiga);
    }


    public void buscaSenhaAntiga(int id){
      antigaDao.buscaSenhaAntiga(id);

    }


}
