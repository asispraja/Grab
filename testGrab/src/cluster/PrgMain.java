package cluster;

import java.util.ArrayList;
import java.util.List;

public class PrgMain {
    public static void main (String args[]){
        List<DataPoint> dataPoints = new ArrayList<DataPoint>();
        dataPoints.add(new DataPoint(22,21,"p53"));
        dataPoints.add(new DataPoint(19,20,"bcl2"));
        dataPoints.add(new DataPoint(18,22,"fas"));
        dataPoints.add(new DataPoint(1,3,"amylase"));
        dataPoints.add(new DataPoint(3,2,"maltase"));
        dataPoints.add(new DataPoint(-1,3,"amylase"));
        dataPoints.add(new DataPoint(6,3,"amylase"));
        dataPoints.add(new DataPoint(5,3,"amylase"));
        dataPoints.add(new DataPoint(1,6,"amylase"));
        dataPoints.add(new DataPoint(1,5,"amylase"));
        JCA jca = new JCA(3,1000,dataPoints);
        jca.startAnalysis();
        int i=0;
        for (List<DataPoint> tempV : jca.getClusterOutput()){
            System.out.println("-----------Cluster"+i+"---------");
            for (DataPoint dpTemp : tempV){
                System.out.println(dpTemp.getObjName()+
                                   "["+dpTemp.getX()+","+dpTemp.getY()+"]");
            }
            i++;
        }
    }
}