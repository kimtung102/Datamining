/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws Exception {
        KNNModel model = new KNNModel("", "-K 3 -W 0 -A \"weka.core.neighboursearch.LinearNNSearch -A \\\"weka.core.EuclideanDistance -R first-last\\\"\"", null);
        model.buildkNN("D:\\train.arff");
        model.evalutekNN("D:\\valid.arff");
        model.predictClassLabel("D:\\unlabel.arff", "D:\\predict_knn.arff");
        System.out.println(model);
    }
}
