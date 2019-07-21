package br.com.wvs.dao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;


@Retention(RUNTIME)
@Target({METHOD,FIELD,PARAMETER})
@Qualifier
public @interface SqlServer {

}
