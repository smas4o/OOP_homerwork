package collections_part_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		
//		ArrayList<ArrayList<ArrayList<String>>>> = 
		
		List<Rakia> maza = new LinkedList<Rakia>();
		maza.add(new Rakia(40, 5, "grozdova"));
		maza.add(new Rakia(35, 2, "dyulova"));
		maza.add(new Rakia(30, 1, "kaisieva"));
		maza.add(new Rakia(50, 30, "sliva-parcuca"));
		maza.add(new Rakia(80, 50, "ot djanki"));
//		maza.add(null); // <- never do that
		
		System.out.println(maza.contains(new Rakia(80, 50, "ot djanki")));
		
		Collections.sort(maza, (r1,r2)-> r1.gradus - r2.gradus);
		
		for (Rakia r : maza) {
			System.out.println(r);
		}
		
		ArrayList<String> pokupki = new ArrayList<String>();
		
//		pokupki.ensureCapacity(300000);
		
		pokupki.add("sirene");
		pokupki.add("loi");
		pokupki.add("obuvki");
		pokupki.add("rakiq");
		pokupki.add("mas");
		pokupki.add("kompot");
		pokupki.add("carska turshiq");
		pokupki.add("hlqb");
		
		System.out.println(pokupki.contains("rakiq"));
		
//		pokupki.add(pokupki.size()+1, "meze");
		pokupki.remove(4);
		System.out.println(pokupki.indexOf("kompot"));
		System.out.println(pokupki.get(4));
		
		System.out.println("Broi pokupki " + pokupki.size());
//		for (int index = 0; index < pokupki.size(); index++) {
//			System.out.println(pokupki.get(index));
//		}
		
		for (String pokupka : pokupki) {
			System.out.println(pokupka);
		}
		
	}
}
