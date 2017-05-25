package tools;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Stats {
	//Field Vars
	private double[] data;
	
	//Constructor
	public Stats(String filename){
		In in = new In(filename);
		if(!in.isEmpty()){
			try {
				this.data = in.readAllDoubles();
				Arrays.sort(this.data);
			} catch (Exception e) {
				System.out.println("Input error\n" + e);
			}
		}else{
			System.out.println("File is empty!");
		}
		
	}
	//Methods
	public double[] get(){
		return data;
	}
	
	public double mean(){
		double mean = 0;
		for(double el:data){
			mean += el;
		}  
		return mean/data.length;
	}

	public double median(){
		double median = 0;
		if(data.length % 2 == 0) median = data[data.length/2] + data[(data.length/2)+1];
		else median = data[data.length/2];
		return median;
	}
	public Queue<Double> mode(){
		Queue<Double> modes = new Queue<>();
		int totalCount = 0;
		double mode = 0;
		int count = 0;
		int startIndex = 0;
		for(int i = 0; i < data.length; i++){
			if(i == data.length -1){
				if(data[i] == data[startIndex]) count += 1;
				modeKeeper(i,count,totalCount,modes);
			}
			if(data[i] == data[startIndex]) count += 1;
			else {
				modeKeeper(i,count,totalCount,modes);
				startIndex = i;
				i -= 1;
				count = 0;	
			}
		}
		
		return modes;
	}
	
	public double stdDev(){
		double sum = 0;
		for(double el : data){
			double diff = Math.pow((this.mean()-el),2);
			sum += diff;
		}

		return Math.sqrt((sum/(data.length-1))); 
	}
	public double sigma(){
		double sum = 0;
		for(double el : data){
			double diff = Math.pow((this.mean()-el),2);
			sum += diff;
		}
		return Math.sqrt((sum/(data.length)));
	}
	public double variance(){
		return Math.pow(this.sigma(),2);
	}
	
	private void modeKeeper(int i, int count, int totalCount, Queue<Double> modes){
		if(count > totalCount){
			if(!modes.isEmpty()){
				modes = new Queue<>();
			}
			totalCount = count;
			modes.enqueue(data[i-1]);
		}
		
		else if(count == totalCount){
			modes.enqueue(data[i-1]);
		}
	}

}
