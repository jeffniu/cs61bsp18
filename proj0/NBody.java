public class NBody {

	/** given a file name, returns radius of the universe */
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

	/** given a file name, returns an array of planets */
	public static Planet[] readPlanets(String txtFileName) {

		In in = new In(txtFileName);

		int numberOfPlanet = in.readInt();
		double radius = in.readDouble();

		Planet[] allPlanets = new Planet[numberOfPlanet];

		for (int i = 0; i < allPlanets.length; i ++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

		}
		return allPlanets;
	}

	/**public static void main(String[] args) {
		 
		if (args.length == 0) {
			System.out.println("Please enter a txt file name as a command line argument");
		} else {
			System.out.println(readPlanets(args[0]));
		}
	}*/
	
}