/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;

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
    private float freeSulfurDioxide;
    private float totalSulfurDioxide;
    private float density;
    private float pH;
    private float sulphates;
    private float alcohol;

    public Wine(float fixedAcidity, float volatileAcidity, float citricAcid, float residualSugar, float chlorides, float freeSulfurDioxide, float totalSulfurDioxide, float density, float pH, float sulphates, float alcohol) {
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

    public Wine() {

    }

    public void dataToArff() throws Exception {
        FastVector atts;
        FastVector attVals;
        Instances data;
        double[] vals;
        int i;

        //setup attribute
        atts = new FastVector();
        //numberic
        atts.addElement(new Attribute("fixed acidity"));
        atts.addElement(new Attribute("volatile acidity"));
        atts.addElement(new Attribute("citric acid"));
        atts.addElement(new Attribute("residual sugar"));
        atts.addElement(new Attribute("chlorides"));
        atts.addElement(new Attribute("free sulfur dioxide"));
        atts.addElement(new Attribute("total sulfur dioxide"));
        atts.addElement(new Attribute("density"));
        atts.addElement(new Attribute("pH"));
        atts.addElement(new Attribute("sulphates"));
        atts.addElement(new Attribute("alcohol"));
        //nominal
        attVals = new FastVector();
        for (i = 1; i <= 10; i++) {
            attVals.addElement(String.valueOf(i));
        }
        atts.addElement(new Attribute("quality", attVals));
        
        // create Instances object
        data = new Instances("test", atts, 0);
        // fill data
        // my instance
        vals = new double[data.numAttributes()];
        // - numeric
        vals[0] = fixedAcidity;
        vals[1] = volatileAcidity;
        vals[2] = citricAcid;
        vals[3] = residualSugar;
        vals[4] = chlorides;
        vals[5] = freeSulfurDioxide;
        vals[6] = totalSulfurDioxide;
        vals[7] = density;
        vals[8] = pH;
        vals[9] = sulphates;
        vals[10] = alcohol;
        //missing value for predict
        vals[11] = Utils.missingValue();
        //add
        data.add(new DenseInstance(1.0, vals));

        //output data
        System.out.println(data);
        //xuat data ra file arff
        BufferedWriter outWriter = new BufferedWriter(new FileWriter("D:\\wine-unlabel.arff"));
        outWriter.write(data.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
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
