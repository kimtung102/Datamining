/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author tranluan
 */
public class DecisionTreeModel extends KnowledgeModel {

    public J48 tree;
    Evaluation eval;

    public DecisionTreeModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }

    public void buildDecisionTree(String filename) throws Exception {
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.tree = new J48();
        tree.setOptions(model_options);
        tree.buildClassifier(this.trainset);
    }

    public String evaluteTree(String filename) throws Exception {
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        Random rnd = new Random(1);
        int folds = 10;
        eval = new Evaluation(this.trainset);
        eval.crossValidateModel(tree, this.testset, folds, rnd);
        String str = eval.toSummaryString("\nDecisionTreeModel 10-fold Cross-validation\n-----------------"
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
            double predict = tree.classifyInstance(unlabel.instance(i));
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
        double predict = tree.classifyInstance(data);
        data.setClassValue(predict);
        Attribute quality = data.attribute(11);
        return data.toString(quality);
    }
}
