package cluster;

public class CCentroid {
    private double mCx, mCy;
    private Cluster mCluster;

    public CCentroid(double cx, double cy) {
        mCx = cx;
        mCy = cy;
    }

    public void calcCentroid() { //only called by CAInstance
        int numDP = mCluster.getNumDataPoints();
        double tempX = 0, tempY = 0;
        int i;
        //caluclating the new Centroid
        for (DataPoint dp : mCluster.getDataPoints()) {
            tempX += dp.getX(); 
            //total for x
            tempY += dp.getY(); 
            //total for y
        }
        mCx = tempX / numDP;
        mCy = tempY / numDP;
        //calculating the new Euclidean Distance for each Data Point
        for (DataPoint dp : mCluster.getDataPoints()) {
            dp.calcEuclideanDistance();
        }
        //calculate the new Sum of Squares for the Cluster
        mCluster.calcSumOfSquares();
    }

    public void setCluster(Cluster c) {
        mCluster = c;
    }

    public double getCx() {
        return mCx;
    }

    public double getCy() {
        return mCy;
    }

    public Cluster getCluster() {
        return mCluster;
    }

}