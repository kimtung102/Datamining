/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Debug;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;


public class KNNModel extends KnowledgeModel{
    IBk knn;
    Evaluation eval;

    public KNNModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }

    public void buildkNN(String filename) throws Exception{
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.knn = new IBk();
        knn.setOptions(model_options);
        knn.buildClassifier(this.trainset);
    }
    
    public String evalutekNN(String filename) throws Exception{
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        Random rnd = new Random(1);
        int folds = 10;
        eval = new Evaluation(this.trainset);
        eval.crossValidateModel(knn, this.testset, folds, rnd);
        String str = eval.toSummaryString("\nKet qua danh gia mo hinh 10-fold cross-validation\n-----\n",false);
        return str;
    }
 
    public void predictClassLabel(String fileIn,String fileOut) throws Exception{
        //Doc du lieu can du doan vao bo nho: file unlabel
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes()-1);
        //Du doan classLabel cho tung instances
        for(int i = 0;i<unlabel.numInstances();i++){
            double predict = knn.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
            System.out.println(predict);
        }
        //Xuat ket qua ra file out
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
    }

    @Override
    public String toString() {
        return eval.toString(); //To change body of generated methods, choose Tools | Templates.
    }   
}
