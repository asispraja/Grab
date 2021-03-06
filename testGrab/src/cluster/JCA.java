package cluster;

import java.util.Iterator;
import java.util.List;

import com.tdunning.math.stats.Centroid;

public class JCA {
    private Cluster[] clusters;
    private int miter;
    private List<DataPoint> mDataPoints;
    private double mSWCSS;

    public JCA(int k, int iter, List<DataPoint> dataPoints) {
        clusters = new Cluster[k];
        for (int i = 0; i < k; i++) {
            clusters[i] = new Cluster("Cluster" + i);
        }
        miter = iter;
        mDataPoints = dataPoints;
    }

    private void calcSWCSS() {
        double temp = 0;
        for (Cluster c : clusters) {
            temp += c.getSumSqr();
        }
        mSWCSS = temp;
    }

    public void startAnalysis() {
        //set Starting centroid positions - Start of Step 1
        setInitialCentroids();
        Iterator<DataPoint> n = mDataPoints.iterator();
        //assign DataPoint to clusters
        loop1:
        while (true) {
            for (Cluster c : clusters) 
            {
                c.addDataPoint(n.next());
                if (!n.hasNext())
                    break loop1;
            }
        }
        
        //calculate E for all the clusters
        calcSWCSS();
        
        //recalculate Cluster centroids - Start of Step 2
        
        for (Cluster c : clusters) {
            c.getCentroid().calcCentroid();
        }
        
        //recalculate E for all the clusters
        calcSWCSS();

        for (int i = 0; i < miter; i++) {
            //enter the loop for cluster 1
            for (Cluster c : clusters) {
                for (Iterator<DataPoint> k = c.getDataPoints().iterator(); k.hasNext(); ) {
                    DataPoint dp = k.next();
                
                    //pick the first element of the first cluster
                    //get the current Euclidean distance
                    double tempEuDt = dp.getCurrentEuDt();
                    Cluster tempCluster = null;
                    boolean matchFoundFlag = false;
                    
                    //call testEuclidean distance for all clusters
                    for (Cluster d : clusters) {
                    
                        //if testEuclidean < currentEuclidean then
                        if (tempEuDt > dp.testEuclideanDistance(d.getCentroid())) {
                            tempEuDt = dp.testEuclideanDistance(d.getCentroid());
                            tempCluster = d;
                            matchFoundFlag = true;
                        }
                        //if statement - Check whether the Last EuDt is > Present EuDt 
                        
                    }
                    //for variable 'd' - Looping between different Clusters for matching a Data Point.
                    //add DataPoint to the cluster and calcSWCSS

                    if (matchFoundFlag) {
		        tempCluster.addDataPoint(dp);
		        k.remove();
                        for (Cluster d : clusters) {
                            d.getCentroid().calcCentroid();
                        }

                        //for variable 'd' - Recalculating centroids for all Clusters

                        calcSWCSS();
                    }
                    
                    //if statement - A Data Point is eligible for transfer between Clusters.
                }
                //for variable 'k' - Looping through all Data Points of the current Cluster.
            }//for variable 'c' - Looping through all the Clusters.
        }//for variable 'i' - Number of iterations.
    }

    public List<DataPoint>[] getClusterOutput() {
        List<DataPoint>[] v = new List[clusters.length];
        int i =0;
        for (Cluster c : clusters) {
            v[i] = c.getDataPoints();
            i++;
        }
        return v;
    }


    private void setInitialCentroids() {
        //kn = (round((max-min)/k)*n)+min where n is from 0 to (k-1).
        double cx = 0, cy = 0;
        for (int n = 1; n <= clusters.length; n++) {
            cx = (((getMaxXValue() - getMinXValue()) / (clusters.length + 1)) * n) + getMinXValue();
            cy = (((getMaxYValue() - getMinYValue()) / (clusters.length + 1)) * n) + getMinYValue();
            CCentroid c1 = new CCentroid(cx, cy);
            clusters[n - 1].setCentroid(c1);
            c1.setCluster(clusters[n - 1]);
        }
    }

    private double getMaxXValue() {
        double temp = mDataPoints.get(0).getX();
        for (DataPoint dp : mDataPoints) {
            temp = (dp.getX() > temp) ? dp.getX() : temp;
        }
        return temp;
    }

    private double getMinXValue() {
        double temp = 0;
        temp = mDataPoints.get(0).getX();
        for (DataPoint dp : mDataPoints) {
            temp = (dp.getX() < temp) ? dp.getX() : temp;
        }
        return temp;
    }

    private double getMaxYValue() {
        double temp = 0;
        temp = mDataPoints.get(0).getY();
        for (DataPoint dp : mDataPoints) {
            temp = (dp.getY() > temp) ? dp.getY() : temp;
        }
        return temp;
    }

    private double getMinYValue() {
        double temp = 0;
        temp = mDataPoints.get(0).getY();
        for (DataPoint dp : mDataPoints) {
            temp = (dp.getY() < temp) ? dp.getY() : temp;
        }
        return temp;
    }

    public int getKValue() {
        return clusters.length;
    }

    public int getIterations() {
        return miter;
    }

    public int getTotalDataPoints() {
        return mDataPoints.size();
    }

    public double getSWCSS() {
        return mSWCSS;
    }

    public Cluster getCluster(int pos) {
        return clusters[pos];
    }
}
