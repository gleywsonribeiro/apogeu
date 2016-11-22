/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gleyw
 */
@Entity
public class Membro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private String nome;
    
    @Column(name = "rg_eclesiastico", length = 30)
    private String rgEclesiastico;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_cadastro", nullable = false)
    private Date dataCadastro;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Column(name = "estado_civil", length = 30)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    
    @Column(length = 50)
    private String naturalidade;
    
    @Column(length = 50)
    private String nacionalidade;
    
    @Column(length = 20)
    private String rg;
    
    @Column(name = "emissor_rg", length = 50)
    private String emissorRg;
    
    @Column(nullable = false, length = 15)
    private String cpf;
    
    @Column(name = "titulo_eleitor", length = 15)
    private String tituloEleitor;
    
    @Column(name = "zona_titulo", length = 30)
    private String zonaTitulo;
    
    @Column(name = "secao_titulo", length = 30)
    private String secaoTitulo;
    
    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;
    
    @Column(length = 30)
    private String profissao;
    
    @Column(name = "nome_pai")
    private String nomePai;
    
    @Column(name = "nome_mae")
    private String nomeMae;
    
    private String conjuge;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_casamento")
    private Date dataCasamento;

    private boolean evangelico;
    private boolean consagrado;
    private boolean ministerio;

    @Column(columnDefinition = "text", name = "local_ministerio")
    private String localMinisterio;
    private String consagrador;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_consagracao")
    private Date dataConsagracao;
    
    @Column(name = "batizado_aguas")
    private boolean batizadoAguas;
    
    private boolean falecido;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_batismo_aguas")
    private Date dataBatismoAguas;
    
    @Column(name = "batizado_es")
    private boolean batizadoEspiritoSanto;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_batismo_es")
    private Date dataBatismoEspiritoSanto;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_admissao")
    private Date dataAdmissao;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_disciplina")
    private Date dataDisciplina;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_falecimento")
    private Date dataFalecimento;
    
    @Column(name = "tp_membro", length = 20)
    @Enumerated(EnumType.STRING)
    private TipoMembro tipoMembro;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_venc_carteira")
    private Date dataVencimentoCarteira;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_aceitou_jesus")
    private Date dataAceitouJesus;
    
    @ManyToOne
    //@JoinColumn(nullable = false)
    private Situacao situacao;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Admissao admissao;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Cargo cargo;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Funcao funcao;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Integracao integracao;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Templo templo;
    
    @ManyToOne
    private Classe turma;
    
    @OneToOne(mappedBy = "professor")
    private Classe classe;
   
    
    @Lob
    private byte[] foto;

    @OneToMany(mappedBy = "membro")
    private List<Filho> filhos;

    //composição
    @Embedded
    private Endereco endereco;
    @Embedded
    private InfoEmpresa empresa;
    @Embedded
    private Contato contato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classe getTurma() {
        return turma;
    }

    public void setTurma(Classe turma) {
        this.turma = turma;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    public List<Filho> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Filho> filhos) {
        this.filhos = filhos;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Admissao getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Admissao admissao) {
        this.admissao = admissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Integracao getIntegracao() {
        return integracao;
    }

    public void setIntegracao(Integracao integracao) {
        this.integracao = integracao;
    }

    public String getRgEclesiastico() {
        return rgEclesiastico;
    }

    public boolean isFalecido() {
        return falecido;
    }

    public void setFalecido(boolean falecido) {
        this.falecido = falecido;
    }
    
    

    public void setRgEclesiastico(String rgEclesiastico) {
        this.rgEclesiastico = rgEclesiastico;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmissorRg() {
        return emissorRg;
    }

    public void setEmissorRg(String emissorRg) {
        this.emissorRg = emissorRg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getZonaTitulo() {
        return zonaTitulo;
    }

    public void setZonaTitulo(String zonaTitulo) {
        this.zonaTitulo = zonaTitulo;
    }

    public String getSecaoTitulo() {
        return secaoTitulo;
    }

    public void setSecaoTitulo(String secaoTitulo) {
        this.secaoTitulo = secaoTitulo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public Date getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(Date dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public boolean isEvangelico() {
        return evangelico;
    }

    public void setEvangelico(boolean evangelico) {
        this.evangelico = evangelico;
    }

    public boolean isConsagrado() {
        return consagrado;
    }

    public void setConsagrado(boolean consagrado) {
        this.consagrado = consagrado;
    }

    public boolean isMinisterio() {
        return ministerio;
    }

    public void setMinisterio(boolean ministerio) {
        this.ministerio = ministerio;
    }

    public String getLocalMinisterio() {
        return localMinisterio;
    }

    public void setLocalMinisterio(String localMinisterio) {
        this.localMinisterio = localMinisterio;
    }

    public String getConsagrador() {
        return consagrador;
    }

    public void setConsagrador(String consagrador) {
        this.consagrador = consagrador;
    }

    public Date getDataConsagracao() {
        return dataConsagracao;
    }

    public void setDataConsagracao(Date dataConsagracao) {
        this.dataConsagracao = dataConsagracao;
    }

    public boolean isBatizadoAguas() {
        return batizadoAguas;
    }

    public void setBatizadoAguas(boolean batizadoAguas) {
        this.batizadoAguas = batizadoAguas;
    }

    public Date getDataBatismoAguas() {
        return dataBatismoAguas;
    }

    public void setDataBatismoAguas(Date dataBatismoAguas) {
        this.dataBatismoAguas = dataBatismoAguas;
    }

    public boolean isBatizadoEspiritoSanto() {
        return batizadoEspiritoSanto;
    }

    public void setBatizadoEspiritoSanto(boolean batizadoEspiritoSanto) {
        this.batizadoEspiritoSanto = batizadoEspiritoSanto;
    }

    public Date getDataBatismoEspiritoSanto() {
        return dataBatismoEspiritoSanto;
    }

    public void setDataBatismoEspiritoSanto(Date dataBatismoEspiritoSanto) {
        this.dataBatismoEspiritoSanto = dataBatismoEspiritoSanto;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDisciplina() {
        return dataDisciplina;
    }

    public void setDataDisciplina(Date dataDisciplina) {
        this.dataDisciplina = dataDisciplina;
    }

    public Date getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(Date dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public TipoMembro getTipoMembro() {
        return tipoMembro;
    }

    public void setTipoMembro(TipoMembro tipoMembro) {
        this.tipoMembro = tipoMembro;
    }

    public Date getDataVencimentoCarteira() {
        return dataVencimentoCarteira;
    }

    public void setDataVencimentoCarteira(Date dataVencimentoCarteira) {
        this.dataVencimentoCarteira = dataVencimentoCarteira;
    }

    public Date getDataAceitouJesus() {
        return dataAceitouJesus;
    }

    public void setDataAceitouJesus(Date dataAceitouJesus) {
        this.dataAceitouJesus = dataAceitouJesus;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public InfoEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(InfoEmpresa empresa) {
        this.empresa = empresa;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membro)) {
            return false;
        }
        Membro other = (Membro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Membro[ id=" + id + " ]";
    }

}
