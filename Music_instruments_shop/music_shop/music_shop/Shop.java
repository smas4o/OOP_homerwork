package music_shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Shop implements IShop {
	
	private static final int MIN_QUANTITY = 0;
	private static final int CONSTANT_FOR_SHOPS_MONEY = 3000;
	private static final int CONSTANT_FOR_INSTRUMENT_PRICE = 1000;
	private static final int STARTING_QUANTITY = 10;
	
	//neznam do kolko sum bil prav v reshenieto si da vzema synchronized HashMap, no chetoh che kogato polzvam nishki bilo po-dobre ot obiknovenia hashMap
	//kolebaeh se mejdu nego i ConcurrentHashMap, no izbrah synchronized hash map tui kato dava dostup samo na edna nishka do mapa, makar che moje da dovede do
	//supernichestvo mejdu nishkite
	Map<Instrument, Integer> products = Collections.synchronizedMap(new HashMap<Instrument, Integer>());
	Map<Instrument, Integer> soldInstruments = Collections.synchronizedMap(new HashMap<Instrument, Integer>());
	
	private int money;
	
	//konstruirane na magazina
	Shop(){
		for(String instrumentName : new String[] { "violin", "viola", "contrabass"/*, "harp", "guitar", "gadoulka", "tambura", "violoncello"*/}){
			products.put(new Instrument(instrumentName, MusicInstrument.STRINGS, (int)(Math.random() * CONSTANT_FOR_INSTRUMENT_PRICE)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "drums", "timpani", "tarambuka"/*, "congas", "xylophone", "vibraphone", "claves", "maracas", "clapper"*/}){
			products.put(new Instrument(instrumentName, MusicInstrument.PERCUSSIVE, (int)(Math.random() * CONSTANT_FOR_INSTRUMENT_PRICE)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "bagpipe", "waldhorn", "saxophone"/*, "trombone", "tuba", "flugelhorn", "oboe", "clarinet", "pipe"*/}){
			products.put(new Instrument(instrumentName, MusicInstrument.BRASS, (int)(Math.random() * CONSTANT_FOR_INSTRUMENT_PRICE)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "piano", "organ", "grand piano"/*, "accordion", "spinet", "bandoneon"*/}){
			products.put(new Instrument(instrumentName, MusicInstrument.KEYBOARDS, (int)(Math.random() * CONSTANT_FOR_INSTRUMENT_PRICE)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "synthesizer", "electric guitar", "bass guitar"/*, "electric violin"*/}){
			products.put(new Instrument(instrumentName, MusicInstrument.ELECTRONIC, (int)(Math.random() * CONSTANT_FOR_INSTRUMENT_PRICE)), STARTING_QUANTITY);
		}
		this.money = CONSTANT_FOR_SHOPS_MONEY;
		
	}
	
	public int getMoney() {
		return money;
	}
	
	//prodavane na instrumenti
	@Override
	public void sellInstrument(Instrument p, int quantity) throws ShopException{
		synchronized(products){
			if(p != null && quantity > MIN_QUANTITY && products.containsKey(p)){
				int newQuantity = products.get(p);
				if(newQuantity > quantity){
					newQuantity -= quantity;
					products.put(p, newQuantity);
					availableInstruments();
					Instrument instrument = null;
					for(Entry<Instrument, Integer> entry : products.entrySet()){
						if(entry.getKey().equals(p)){
							instrument = entry.getKey();
						}
					}
					countMoney(instrument.getPrice() * quantity);
					System.out.println(this.getMoney());
					soldInstruments(instrument,quantity);
					mostSellInstrument();
					mostUnselledInstrument();
				}else{
					throw new ShopException("The instrument is out of stock!");
				}
			}
		}
	}
	
	//dobavqne na instrument
	@Override
	public void addInstrument(Instrument instrument, int quantity) throws ShopException{
		if(instrument != null && quantity > MIN_QUANTITY && products.containsKey(instrument)){
			int newQuantity = products.get(instrument);
			newQuantity += quantity;
			products.put(instrument, newQuantity);
		}else{
			throw new ShopException("Can't add that instrument right now!");
		}
	}
	
	//sortirovkite sa identichni i se razlichavat samo po vrushtani stoinosti koeto ne se seshtam kak da promenq
	@Override
	public void sortedByType(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return instrument1.getKey().getType().compareTo(instrument2.getKey().getType());
			}
		});
		System.out.println(entryList.toString());
	}
	
	@Override
	public void sortedByName(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return instrument1.getKey().getName().compareTo(instrument2.getKey().getName());
			}
		});
		System.out.println(entryList.toString());
	}
	
	@Override
	public void sortedByPrice(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return (instrument1.getKey().getPrice()).compareTo(instrument2.getKey().getPrice());
			}
		});
		System.out.println(entryList.toString());
	}
	
	//pokazva koi instrumenti sa nalichni v momenta
	@Override
	public void availableInstruments(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return (instrument1.getValue()).compareTo(instrument2.getValue());
			}
		});
		System.out.println(entryList.toString());
	}
	
	//pokazva kolko i kakvi instrumenti sa prodadeni
	//purov se dobavqt v map i sled tova se sortirat
	@Override
	public void soldInstruments(Instrument instrument, int quantity){
		soldInstruments.put(instrument, quantity);
	}//lek overloading
	@Override
	public void soldInstruments(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(soldInstruments.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return (instrument1.getValue()).compareTo(instrument2.getValue());
			}
		});
		System.out.println(soldInstruments.toString());
	}
	//izchislqva parite na magazina
	@Override
	public void countMoney(int newAmount){
		this.money += newAmount;
	}
	
	//nai-prodavania instrument v magazina
	@Override
	public void mostSellInstrument(){
		int maxValueInMap = (Collections.max(soldInstruments.values()));
		for(Map.Entry<Instrument, Integer> entry : soldInstruments.entrySet()){
			if(entry.getValue() == maxValueInMap){
				System.out.println("Most selled instrument: " + entry.getKey() + ", number: " + entry.getValue());
			}
		}
	}
	
	//nai-neprodavania instrument v magazina
	@Override
	public void mostUnselledInstrument(){
		int minValueInMap = (Collections.min(soldInstruments.values()));
		for(Map.Entry<Instrument, Integer> entry : soldInstruments.entrySet()){
			if(entry.getValue() == minValueInMap){
				System.out.println("Most unselled instrument: " + entry.getKey() + ", number: " + entry.getValue());
			}
		}
	}
}
