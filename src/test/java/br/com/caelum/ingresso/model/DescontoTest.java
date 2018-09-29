package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.descontos.*;

public class DescontoTest {
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		
		Sala sala= new Sala("Eldorado - Imax", new BigDecimal ("20.50"));
		Filme filme = new Filme("Roque One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme, sala);
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		
		BigDecimal precoEsperado = new BigDecimal("32.50");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
		
	}
	
	@Test
	public void deveConcederDescontode30PorCentoParaIngressoDeClientesdeBancos(){
		
		Sala sala= new Sala("Eldorado - Imax", new BigDecimal ("20.50"));
		Filme filme = new Filme("Roque One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaBancos());
		
		BigDecimal precoEsperado = new BigDecimal("22.75");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void deveConcederDescontode50PorCentoParaIngressoDeEstudante(){
		
		Sala sala= new Sala("Eldorado - Imax", new BigDecimal ("20.50"));
		Filme filme = new Filme("Roque One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaEstudantes());
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	

}