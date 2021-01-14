package pers.lanqiao.impl;

import pers.lanqiao.intrerface.IInk;
import pers.lanqiao.intrerface.IPaper;

public class Printer {
	private IInk ink;
	private IPaper paper;
	private String brand;

	public Printer(String brand) {
		this.brand = brand;
	}

	public String print() {
		return this.getBrand() + "打印机正在使用" + this.getInk().getInkColor() + "墨水和" + this.getPaper().getPaperSize() + "纸来进行打印";
	}

	public IInk getInk() {
		return ink;
	}

	public void setInk(IInk ink) {
		this.ink = ink;
	}

	public IPaper getPaper() {
		return paper;
	}

	public void setPaper(IPaper paper) {
		this.paper = paper;
	}

	public String getBrand() {
		return brand;
	}
}
