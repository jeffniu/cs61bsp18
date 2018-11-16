public class NBody {
	public static double readRadius(String txtFileName) {
		
		In in = new In(txtFileName);

		int numberOfPlanet = in.readInt();
		double radius = in.readDouble();

		return radius;

	}

	/*public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Please enter a txt file name as a command line argument");
		} else {
			System.out.println(readRadius(args[0]));
		}
		
	}*/
}