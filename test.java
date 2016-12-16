package cn.edu.usst;

import java.awt.geom.Area;
import java.util.Scanner;

public class Circle {
	public static final double PI=3.14;
	public static double computeArea(double r){
		double area=PI*r*r;
		return area;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r;
		double area;
		System.out.print("«Î ‰»Î∞Îæ∂£∫");
		Scanner sc = new Scanner(System.in);
		r=sc.nextDouble();
		area=computeArea(r);
		System.out.println("the area is "+area);
	}

}
