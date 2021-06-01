package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.modelos.Jogador;
import br.com.codenation.modelos.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<Time>();
  private List<Jogador> jogadores = new ArrayList<Jogador>();

	private Time buscarTime(Long id) {
		Time time = null;

		for (Time value : times) {
			if (value.getId().equals(id)) {
				time = value;
			}
		}
		return time;
	}

	private Jogador buscarJogador(Long id) {
		Jogador jogador = null;

		for (Jogador value : jogadores) {
			if (value.getId().equals(id)) {
				jogador = value;
			}
		}

		return jogador;
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
													String corUniformeSecundario) {
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);

		if (buscarTime(id) != null) {
			throw new IdentificadorUtilizadoException();
		}

		times.add(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
														 Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);

		if (buscarJogador(id) != null) {
			throw new IdentificadorUtilizadoException();
		} else if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		jogadores.add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);

		if (jogador == null) {
			throw new JogadorNaoEncontradoException();
		}

		jogadores.forEach(item -> {
			if (item.isCapitao() && item.getIdTime() == jogador.getIdTime()) {
				item.setCapitao(false);
			}
		});

		jogador.setCapitao(true);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Jogador jogador = null;

		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		for (Jogador element : jogadores) {
			if (element.getIdTime() == idTime && element.isCapitao()) {
				jogador = element;
			}
		}

		if (jogador == null) {
			throw new CapitaoNaoInformadoException();
		}

		return jogador.getId();
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);

		if (jogador == null) {
			throw new JogadorNaoEncontradoException();
		}

		return jogador.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		Time time = buscarTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException();
		}

		return time.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		List<Jogador> jogadoresDoTime = jogadores
						.stream().filter(jogador -> jogador.getIdTime() == idTime)
						.collect(Collectors.toList());
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getId));

		List<Long> listaDeJogadores = new ArrayList<Long>();

		jogadoresDoTime.forEach(element -> {
			listaDeJogadores.add(element.getId());
		});

		return listaDeJogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		List<Jogador> jogadoresDoTime = jogadores
						.stream().filter(jogador -> jogador.getIdTime() == idTime)
						.collect(Collectors.toList());
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getNivelHabilidade));

		return jogadoresDoTime.get(jogadoresDoTime.size() - 1).getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		List<Jogador> jogadoresDoTime = jogadores
						.stream().filter(jogador -> jogador.getIdTime() == idTime)
						.collect(Collectors.toList());
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getDataNascimento));

		return jogadoresDoTime.get(jogadoresDoTime.size() - 2).getId();
	}

	public List<Long> buscarTimes() {
		times.sort(Comparator.comparing(Time::getId));

		List<Long> idTimes = new ArrayList<Long>();

		times.forEach(time -> idTimes.add(time.getId()));

		return idTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		List<Jogador> jogadoresDoTime = jogadores
						.stream().filter(jogador -> jogador.getIdTime() == idTime)
						.collect(Collectors.toList());

		jogadoresDoTime.sort(Comparator.comparing(Jogador::getSalario));

		return jogadoresDoTime.get(jogadoresDoTime.size() - 1).getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (buscarJogador(idJogador) == null) {
			throw new JogadorNaoEncontradoException();
		}

		List<Jogador> salarioJogador = jogadores
						.stream().filter(jogador -> jogador.getId() == idJogador)
						.collect(Collectors.toList());

		return salarioJogador.get(0).getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		jogadores.sort(Comparator.comparing(Jogador::getNivelHabilidade));

		List<Long> idTop = new ArrayList<Long>();
		if (jogadores.size() > 0) {
			for (int index = jogadores.size() - 1; index >= (jogadores.size() - top); index--) {
				idTop.add(jogadores.get(index).getId());
			}
		}

		return idTop;
	}

}
