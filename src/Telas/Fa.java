/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author gilson.alves
 */
@Entity
@Table(name = "fa", catalog = "retorno_1", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Fa.findAll", query = "SELECT f FROM Fa f"),
    @NamedQuery(name = "Fa.findByFa", query = "SELECT f FROM Fa f WHERE f.fa = :fa"),
    @NamedQuery(name = "Fa.findByNome", query = "SELECT f FROM Fa f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fa.findByData", query = "SELECT f FROM Fa f WHERE f.data = :data"),
    @NamedQuery(name = "Fa.findByTecnicotriagem", query = "SELECT f FROM Fa f WHERE f.tecnicotriagem = :tecnicotriagem"),
    @NamedQuery(name = "Fa.findByObs", query = "SELECT f FROM Fa f WHERE f.obs = :obs")})
public class Fa implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fa")
    private String fa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data")
    private String data;
    @Column(name = "tecnicotriagem")
    private String tecnicotriagem;
    @Column(name = "obs")
    private String obs;

    public Fa() {
    }

    public Fa(String fa) {
        this.fa = fa;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        String oldFa = this.fa;
        this.fa = fa;
        changeSupport.firePropertyChange("fa", oldFa, fa);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getTecnicotriagem() {
        return tecnicotriagem;
    }

    public void setTecnicotriagem(String tecnicotriagem) {
        String oldTecnicotriagem = this.tecnicotriagem;
        this.tecnicotriagem = tecnicotriagem;
        changeSupport.firePropertyChange("tecnicotriagem", oldTecnicotriagem, tecnicotriagem);
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        String oldObs = this.obs;
        this.obs = obs;
        changeSupport.firePropertyChange("obs", oldObs, obs);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fa != null ? fa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fa)) {
            return false;
        }
        Fa other = (Fa) object;
        if ((this.fa == null && other.fa != null) || (this.fa != null && !this.fa.equals(other.fa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telas.Fa[ fa=" + fa + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
