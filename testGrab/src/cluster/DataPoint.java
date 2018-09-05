package cluster;

public class DataPoint{
    private double mX,mY;
    private String mObjName;
    private Cluster mCluster;
    private double mEuDt;

    public DataPoint(double x, double y, String name) {
        mX = x;
        mY = y;
        mObjName = name;
    }

    public void setCluster(Cluster cluster) {
        mCluster = cluster;
        calcEuclideanDistance();
    }

    public void calcEuclideanDistance() { 
    
        //called when DP is added to a cluster or when a Centroid is recalculated.
        mEuDt = Math.hypot(mX - mCluster.getCentroid().getCx(),
                           mY - mCluster.getCentroid().getCy());
    }
//CHange to cosine similarity
    public double testEuclideanDistance(CCentroid c) {
        return Math.sqrt(Math.pow((mX - c.getCx()), 2) + Math.pow((mY - c.getCy()), 2));
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }

    public Cluster getCluster() {
        return mCluster;
    }

    public double getCurrentEuDt() {
        return mEuDt;
    }

    public String getObjName() {
        return mObjName;
    }

}