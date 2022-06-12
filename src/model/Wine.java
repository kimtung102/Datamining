/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Wine {
    private float fixedAcidity;
    private float volatileAcidity;
    private float citricAcid;
    private float residualSugar;
    private float chlorides;
    private int freeSulfurDioxide;
    private int totalSulfurDioxide;
    private float density;
    private float pH;
    private float sulphates;
    private float alcohol;

    public Wine(float fixedAcidity, float volatileAcidity, float citricAcid, float residualSugar, float chlorides, int freeSulfurDioxide, int totalSulfurDioxide, float density, float pH, float sulphates, float alcohol) {
        this.fixedAcidity = fixedAcidity;
        this.volatileAcidity = volatileAcidity;
        this.citricAcid = citricAcid;
        this.residualSugar = residualSugar;
        this.chlorides = chlorides;
        this.freeSulfurDioxide = freeSulfurDioxide;
        this.totalSulfurDioxide = totalSulfurDioxide;
        this.density = density;
        this.pH = pH;
        this.sulphates = sulphates;
        this.alcohol = alcohol;
    }
    
    public float getFixedAcidity() {
        return fixedAcidity;
    }

    public void setFixedAcidity(float fixedAcidity) {
        this.fixedAcidity = fixedAcidity;
    }

    public float getVolatileAcidity() {
        return volatileAcidity;
    }

    public void setVolatileAcidity(float volatileAcidity) {
        this.volatileAcidity = volatileAcidity;
    }

    public float getCitricAcid() {
        return citricAcid;
    }

    public void setCitricAcid(float citricAcid) {
        this.citricAcid = citricAcid;
    }

    public float getResidualSugar() {
        return residualSugar;
    }

    public void setResidualSugar(float residualSugar) {
        this.residualSugar = residualSugar;
    }

    public float getChlorides() {
        return chlorides;
    }

    public void setChlorides(float chlorides) {
        this.chlorides = chlorides;
    }

    public float getFreeSulfurDioxide() {
        return freeSulfurDioxide;
    }

    public void setFreeSulfurDioxide(float freeSulfurDioxide) {
        this.freeSulfurDioxide = freeSulfurDioxide;
    }

    public float getTotalSulfurDioxide() {
        return totalSulfurDioxide;
    }

    public void setTotalSulfurDioxide(float totalSulfurDioxide) {
        this.totalSulfurDioxide = totalSulfurDioxide;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public float getpH() {
        return pH;
    }

    public void setpH(float pH) {
        this.pH = pH;
    }

    public float getSulphates() {
        return sulphates;
    }

    public void setSulphates(float sulphates) {
        this.sulphates = sulphates;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }   
}
