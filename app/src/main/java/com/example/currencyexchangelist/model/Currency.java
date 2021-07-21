package com.example.currencyexchangelist.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(primaryKeys = {"datumPrimjene", "valuta"})
public class Currency {

    @SerializedName("Broj te\u010dajnice")
    @Expose
    private String brojTeAjnice;
    @SerializedName("Datum primjene")
    @Expose
    @NonNull
    private String datumPrimjene;
    @SerializedName("Dr\u017eava")
    @Expose
    private String drAva;
    @SerializedName("\u0160ifra valute")
    @Expose
    private String ifraValute;
    @SerializedName("Valuta")
    @Expose
    @NonNull
    private String valuta;
    @SerializedName("Jedinica")
    @Expose
    private Integer jedinica;
    @SerializedName("Kupovni za devize")
    @Expose
    private String kupovniZaDevize;
    @SerializedName("Srednji za devize")
    @Expose
    private String srednjiZaDevize;
    @SerializedName("Prodajni za devize")
    @Expose
    private String prodajniZaDevize;

    public String getBrojTeAjnice() {
        return brojTeAjnice;
    }

    public void setBrojTeAjnice(String brojTeAjnice) {
        this.brojTeAjnice = brojTeAjnice;
    }

    public String getDatumPrimjene() {
        return datumPrimjene;
    }

    public void setDatumPrimjene(String datumPrimjene) {
        this.datumPrimjene = datumPrimjene;
    }

    public String getDrAva() {
        return drAva;
    }

    public void setDrAva(String drAva) {
        this.drAva = drAva;
    }

    public String getIfraValute() {
        return ifraValute;
    }

    public void setIfraValute(String ifraValute) {
        this.ifraValute = ifraValute;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Integer getJedinica() {
        return jedinica;
    }

    public void setJedinica(Integer jedinica) {
        this.jedinica = jedinica;
    }

    public String getKupovniZaDevize() {
        return kupovniZaDevize;
    }

    public void setKupovniZaDevize(String kupovniZaDevize) {
        this.kupovniZaDevize = kupovniZaDevize;
    }

    public String getSrednjiZaDevize() {
        return srednjiZaDevize;
    }

    public void setSrednjiZaDevize(String srednjiZaDevize) {
        this.srednjiZaDevize = srednjiZaDevize;
    }

    public String getProdajniZaDevize() {
        return prodajniZaDevize;
    }

    public void setProdajniZaDevize(String prodajniZaDevize) {
        this.prodajniZaDevize = prodajniZaDevize;
    }


    @Override
    public String toString() {
        return valuta + " (" + drAva + ")\n"
                + kupovniZaDevize + "\t\t|\t\t" + srednjiZaDevize + "\t\t|\t\t" + prodajniZaDevize;
    }
}
