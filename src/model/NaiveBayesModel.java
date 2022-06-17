/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.Debug;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author tranluan
 */
public class NaiveBayesModel extends KnowledgeModel {

    public NaiveBayes nbayes;
    Evaluation eval;

    public NaiveBayesModel() {
        super();
    }

    public NaiveBayesModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }

    public void bui1Naivebayes(String filename) throws Exception {
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.nbayes = new NaiveBayes();
        //nbayes.setOptions(this.model_options);
        nbayes.buildClassifier(this.trainset);
    }

    public String evaluateNaiveBayes(String filename) throws Exception {
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        Debug.Random rnd = new Debug.Random(1);
        int folds = 10;
        eval = new Evaluation(this.trainset);
        eval.crossValidateModel(nbayes, this.testset, folds, rnd);
        String str = eval.toSummaryString("\nNaiveBayesModel 10-fold Cross-validation\n-----------------"
                + "-------------------------------------------\n", false);
        return str;
    }

    public Instances predictClassLabel(String fileIn) throws Exception {
        //Doc du lieu can du doan vao bo nho: file unlabel
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() - 1);
        //Du doan classLabel cho tung instances
        for (int i = 0; i < unlabel.numInstances(); i++) {
            double predict = nbayes.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        return unlabel;
    }

    public String predictOneClassLabel(String fileIn, Instance data) throws Exception {
        //Doc du lieu can du doan vao bo nho: file unlabel
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() - 1);
        data.setDataset(unlabel);
        double predict = nbayes.classifyInstance(data);
        data.setClassValue(predict);
        Attribute quality = data.attribute(11);
        return data.toString(quality);
    }
}
