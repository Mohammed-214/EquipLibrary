import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainSystem {

	static String fileName = null;
	static EquipmentLibrary eqLi = new EquipmentLibrary();
	static Scanner sc = new Scanner(System.in);
	static Boolean working = true;

	public static void main(String[] args) {
		while (working) {
			System.out.println("\nPress 0 for load a library."
					+ "\nPress 1 for save and quit"
					+ "\nPress 2 for list all equipments in library"
					+ "\nPress 3 for add equipment to library");

			int response = sc.nextInt();
			switch (response) {
			case 0:
				System.out.println("Enter the file name to load");
				FileInputStream f = null;
				ObjectInputStream o = null;
				File file = new File(sc.next() + ".ser");
				if (file.exists()) {
					try {
						f = new FileInputStream(file);
						o = new ObjectInputStream(f);
						eqLi = (EquipmentLibrary) o.readObject();
						f.close();
						o.close();

					} catch (IOException e) {

						e.printStackTrace();
					} catch (ClassNotFoundException e) {

						e.printStackTrace();
					}

				} else {
					System.out.println("\nThe file does not exist!");
				}				break;

			case 1:
				System.out.println("Enter file name: ");
				fileName = sc.next() + ".ser";
				working = false;
				FileOutputStream ff = null;
				ObjectOutputStream oo = null;
				try {
					ff = new FileOutputStream(fileName);
					oo = new ObjectOutputStream(ff);
					oo.writeObject(eqLi);
					ff.close();
					oo.close();
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}				break;
			case 2:
				System.out.println(eqLi.toString());
				break;
			case 3:
				String equipID;
				String equipName;
				String epuipManfc;
				String equipMod;
				String equipSerial;
				String equipMac;
				String equipIp;
				String equipLoc;
				String equipCat;

				System.out.println("\nEnter equipID: ");
				equipID = sc.next();

				System.out.println("\nEnter equipName: ");
				equipName = sc.next();

				System.out.println("\nEnter epuipManfc: ");
				epuipManfc = sc.next();

				System.out.println("\nEnter equipMod: ");
				equipMod = sc.next();

				System.out.println("\nEnter equipSerial: ");
				equipSerial = sc.next();

				System.out.println("\nEnter equipMac: ");
				equipMac = sc.next();

				System.out.println("\nEnter equipIp: ");
				equipIp = sc.next();

				System.out.println("\nEnter equipLoc: ");
				equipLoc = sc.next();

				System.out.println("\nEnter equipCat: ");
				equipCat = sc.next();

				EquipmentInfo eq = new EquipmentInfo( equipID, equipName,  epuipManfc,  equipMod,  equipSerial,  equipMac,  equipIp, equipLoc, equipCat);
				eqLi.addEquip(eq);				break;
			}
		}
		System.exit(0);
	}

	private static void addEquip() {
	}

	private static void saveAndQuit() {
	}

	private static void loadScript(String name) {
	}

}

class EquipmentInfo implements Serializable {
	private String equipID;
	private String equipName;
	private String epuipManfc;
	private String equipMod;
	private String equipSerial;
	private String equipMac;
	private String equipIp;
	private String equipLoc;
	private String equipCat;


	public EquipmentInfo(){
		equipID = "";
		equipIp = "";
		equipMod = "";
		equipName = "";
		epuipManfc= "";
		equipMod= "";
		equipSerial="";
		equipMac="";
		equipIp="";
		equipLoc="";
		equipCat="";

	}

	public EquipmentInfo(String equipID, String equipName, String epuipManfc, String equipMod, String equipSerial, String equipMac, String equipIp, String equipLoc, String equipCat) {
		this.equipID = equipID;
		this.equipName = equipName;
		this.epuipManfc = epuipManfc;
		this.equipMod = equipMod;
		this.equipSerial = equipSerial;
		this.equipMac = equipMac;
		this.equipIp = equipIp;
		this.equipLoc = equipLoc;
		this.equipCat = equipCat;
	}

	public EquipmentInfo(String equipName, String equipIp, String equipMod, String equipSerial, String equipMac, String equipSerial1, String epuipManfc, String equipLoc) {
	}

	@Override
	public String toString() {
		return "Equipments details are: " +
				"\nequipID='" + equipID + '\'' +
				"\nequipName='" + equipName + '\'' +
				"\n, epuipManfc='" + epuipManfc + '\'' +
				"\n, equipMod='" + equipMod + '\'' +
				"\n, equipSerial='" + equipSerial + '\'' +
				"\n, equipMac='" + equipMac + '\'' +
				"\n, equipIp='" + equipIp + '\'' +
				"\n, equipLoc='" + equipLoc + '\'' +
				"\nequipCat='" + equipCat + '\'' +
				'}';
	}

}

class EquipmentLibrary extends Object implements Serializable {

	private List<EquipmentInfo> collection;

	public EquipmentLibrary(){
		collection = new ArrayList<EquipmentInfo>();
	}

	public void addEquip(EquipmentInfo equipmentInfo){
		collection.add(equipmentInfo);
	}

	@Override
	public String toString() {
		String total = "\n";
		/*
		for (int i=0; i<collection.size(); i++){
			Book b = collection.get(i);
			total = total + b.toString();

		}
		*/
		Iterator<EquipmentInfo> i = collection.iterator();
		while(i.hasNext()){
			EquipmentInfo b = (EquipmentInfo) i.next();
			total = total + b.toString();
		}
		return total;
	}

}
