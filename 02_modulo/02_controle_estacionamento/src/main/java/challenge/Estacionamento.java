package challenge;

import java.util.ArrayList;

public class Estacionamento {

  ArrayList<Carro> listaDeCarrosEstacionados = new ArrayList<Carro>();

  public void estacionar(Carro carro) {
    if (carro.getMotorista() == null) {
      throw new EstacionamentoException("Informe um motorista");
    }
    if (carro.getMotorista().getIdade() < 18) {
      throw new EstacionamentoException("O motorista deve ser maior que 18 anos");
    }
    if (carro.getMotorista().getPontos() > 20) {
      throw new EstacionamentoException("Motorista com mais de 20 pontos não pode estacionar");
    }
    int totalDeCarros = carrosEstacionados();
    if (totalDeCarros < 10) {
      listaDeCarrosEstacionados.add(carro);
    } else {
      boolean idosos = true;
      if (listaDeCarrosEstacionados.get(0).getMotorista().getIdade() < 55) {
        listaDeCarrosEstacionados.remove(0);
        listaDeCarrosEstacionados.add(carro);
        idosos = false;
      } else {
        for (int index = 1; index < totalDeCarros; index++) {
          if (listaDeCarrosEstacionados.get(index).getMotorista().getIdade() < 55) {
            listaDeCarrosEstacionados.remove(index);
            listaDeCarrosEstacionados.add(carro);
            idosos = false;
            break;
          }
        }
      }
      if (idosos) {
        throw new EstacionamentoException("O estacionamento está lotado");
      }
    }
  }

  public int carrosEstacionados() {
    return listaDeCarrosEstacionados.size();
  }

  public boolean carroEstacionado(Carro carro) {
    return listaDeCarrosEstacionados.contains(carro);
  }
}
