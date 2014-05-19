package de.thoft.convertpbandtogain;

public class Calculate {
	private double mPband;
	private double mK;
	private double mMeasurementRangeLow;
	private double mMeasurementRangeHigh;
	private double mOutputRangeLow;
	private double mOutputRangeHigh;
	
	public Calculate(double input, double measurementRangeLow, double measurementRangeHigh, double outputRangeLow, double outputRangeHigh, int mode){
		if(mode == 1){
			this.setPband(input);
		}
		else{
			this.setK(input);
		}
		this.setMeasurementRangeLow(measurementRangeLow);
		this.setMeasurementRangeHigh(measurementRangeHigh);
		this.setOutputRangeLow(outputRangeLow);
		this.setOutputRangeHigh(outputRangeHigh);
	}
	public double CalculatePband(){
		double measurementRange = mMeasurementRangeHigh - mMeasurementRangeLow;
		double outputRange = mOutputRangeHigh - mOutputRangeLow;
		return(100 * outputRange/(measurementRange * mK));		
	}
	public double CalculateK(){
		double measurementRange = mMeasurementRangeHigh - mMeasurementRangeLow;
		double outputRange = mOutputRangeHigh - mOutputRangeLow;
		return(100 * outputRange/(measurementRange * mPband));		
	}
	
	public double getPband() {
		return mPband;
	}
	public void setPband(double pband) {
		mPband = pband;
	}
	public double getK() {
		return mK;
	}
	public void setK(double k) {
		mK = k;
	}
	public double getMeasurementRangeLow() {
		return mMeasurementRangeLow;
	}
	public void setMeasurementRangeLow(double measurementRangeLow) {
		mMeasurementRangeLow = measurementRangeLow;
	}
	public double getMeasurementRangeHigh() {
		return mMeasurementRangeHigh;
	}
	public void setMeasurementRangeHigh(double measurementRangeHigh) {
		mMeasurementRangeHigh = measurementRangeHigh;
	}
	public double getOutputRangeLow() {
		return mOutputRangeLow;
	}
	public void setOutputRangeLow(double outputRangeLow) {
		mOutputRangeLow = outputRangeLow;
	}
	public double getOutputRangeHigh() {
		return mOutputRangeHigh;
	}
	public void setOutputRangeHigh(double outputRangeHigh) {
		mOutputRangeHigh = outputRangeHigh;
	}
}
