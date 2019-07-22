package br.com.wvs.dao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

// Criação de uma anotação que devera ser usada como @SqlServer para informar que desejamos usar o banco SQLServer
@Retention(RUNTIME)
@Target({METHOD,FIELD,PARAMETER})
@Qualifier
public @interface SqlServer {

}
