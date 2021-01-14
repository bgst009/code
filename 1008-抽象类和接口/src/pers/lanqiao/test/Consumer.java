package pers.lanqiao.test;

import pers.lanqiao.impl.*;
import pers.lanqiao.intrerface.IInk;
import pers.lanqiao.intrerface.IPaper;

public class Consumer {
	public static void main(String[] args) {

		IInk ink1 = new BlackInk();
		IInk ink2 = new Color();
		IPaper paper1 = new A4();
		IPaper paper2 = new B5();
		Printer printer = new Printer("三星");

		printer.setInk(ink1);
		printer.setPaper(paper1);
		System.out.println(printer.print());
	}
}
