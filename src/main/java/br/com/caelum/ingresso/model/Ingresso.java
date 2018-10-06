package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer Id;
	
	@ManyToOne
	private Sessao sessao;
	
	@ManyToOne
	private Lugar lugar;
	
	private BigDecimal preco;

	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso1;

    public Ingresso() {

    }
    
    
    public BigDecimal getPreco(){
    	
    	return preco.setScale(2, RoundingMode.HALF_UP);
    	
    }
    
    public void setPreco(BigDecimal preco){
    	
    	this.preco = preco;
    			
    }
    
    public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso1;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso1 = tipoDeIngresso;
	}
    
    public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
    	this.sessao=sessao;
    	this.tipoDeIngresso1=tipoDeIngresso;
    	this.preco=this.tipoDeIngresso1.aplicaDesconto(sessao.getPreco());
    	this.lugar=lugar;
    }
}
