package cluster;

import java.util.ArrayList;
import java.util.List;

import com.tdunning.math.stats.Centroid;

public class Cluster {
    private String mName;
    private CCentroid mCentroid; //will be set by calling setCentroid()
    private double mSumSqr;
    private List<DataPoint> mDataPoints = new ArrayList<DataPoint>();

    public Cluster(String name) {
        mName = name;
    }

    public void setCentroid(CCentroid c) {
        mCentroid = c;
    }

    public CCentroid getCentroid() {
        return mCentroid;
    }

    public void addDataPoint(DataPoint dp) { //called from CAInstance
        dp.setCluster(this); //initiates a inner call to calcEuclideanDistance() in DP.
        mDataPoints.add(dp);
        calcSumOfSquares();
    }

    public void removeDataPoint(DataPoint dp) {
        mDataPoints.remove(dp);
        calcSumOfSquares();
    }

    public int getNumDataPoints() {
        return mDataPoints.size();
    }

    public DataPoint getDataPoint(int pos) {
        return mDataPoints.get(pos);
    }

    public void calcSumOfSquares() { //called from Centroid
        double temp = 0;
        for (DataPoint dp : mDataPoints) {
            temp += dp.getCurrentEuDt();
        }
        mSumSqr = temp;
    }

    public double getSumSqr() {
        return mSumSqr;
    }

    public String getName() {
        return mName;
    }

    public List<DataPoint> getDataPoints() {
        return mDataPoints;
    }

}
