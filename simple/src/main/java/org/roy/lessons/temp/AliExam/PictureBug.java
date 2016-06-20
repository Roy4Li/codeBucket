package org.roy.lessons.temp.AliExam;

public class PictureBug {

	/**	
	 * 1、 为使图片看起来更清晰，你有什么办法解决吗？请写下你的思路，如果能写出代码更佳。
	 * 2、浏览的同一图片次数越多，你的办法效果会趋向更好还是更坏？为什么？
	 * 思路：先分析bug. bug是在app端浏览显示的时候出现，如果可以排除原始图片的问题，
	 * 则可以确定bug源于浏览显示部分的程序。
	 * 假如这部分模块，支持修改，支持debug，可以采用debug的方式找到bug并且予以解决，甚至是重写部分方法；
	 * 如果这部分不支持修改，可以根据增量修改的原则，在原有程序的基础上，包裹一层“过滤”处理；
	 * 过滤算法的思路：
	 * 观察bug，出问题时，黑色的“噪音”像素点都是连续的，而且连续的长度很长，可以设置一个合理的阈值，如图片的长度或者宽度，
	 * 达到此阈值的连续黑线可以判断为“噪声”，将每一个像素点再替换为最近一个非全0的像素点即可。
	 * 需要做的步骤：
	 * （1）loadPixel返回的一维像素点数组转换为二维像素点数组；
	 * （2）从坐上角扫描该二维数组，从往右--往下方向寻找连续黑点，若大于阈值，进行临近替换；
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}