package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;
import com.challenge.annotation.*;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel{

  @Override
  public BigDecimal somar(Object object) {
    BigDecimal resultado = BigDecimal.ZERO;

    Class classe = object.getClass();

    for (Field atributo : classe.getDeclaredFields()) {
      if (atributo.isAnnotationPresent(Somar.class) &&
        Objects.equals(atributo.getType().getName(), BigDecimal.class.getName())) {
        atributo.setAccessible(true);
        try {
          resultado = resultado.add( (BigDecimal) atributo.get(object));
        } catch(IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }

    return resultado;
  }

  @Override
  public BigDecimal subtrair(Object object) {
    BigDecimal resultado = BigDecimal.ZERO;

    Class classe = object.getClass();

    for (Field atributo : classe.getDeclaredFields()) {
      if (atributo.isAnnotationPresent(Subtrair.class) &&
        Objects.equals(atributo.getType().getName(), BigDecimal.class.getName())) {
        atributo.setAccessible(true);
        try {
          resultado = resultado.add((BigDecimal) atributo.get(object));

        } catch(IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }

    return resultado;
  }

  @Override
  public BigDecimal totalizar(Object object) {
    return this.somar(object).subtract(this.subtrair(object));
  }

}