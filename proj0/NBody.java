public class NBody {

	/** given a file name, returns radius of the universe */
	public static double readRadius(String txtFileName) {
		
		In in = new In(txtFileName);

		int numberOfPlanet = in.readInt();
		double radius = in.readDouble();

		return radius;

	}

	/** given a file name, returns an array of planets */
	public static Planet[] readPlanets(String txtFileName) {

		In in = new In(txtFileName);

		int numberOfPlanet = in.readInt();
		double radius = in.readDouble();

		Planet[] planets = new Planet[numberOfPlanet];

		for (int i = 0; i < planets.length; i ++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

		}
		return planets;
	}
	
	public static final String IMAGE_DIR = "images";



	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Please enter T dt and txtFileName as command line argument~");
			System.out.println("Example: java NBody 157788000.0 25000.0 data/planets.txt");
		} else {
			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String filename = args[2];
			double radius = readRadius(filename);
			Planet[] planets = readPlanets(filename);
			/*StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0,0, "images/starfield.jpg");
			StdDraw.show();

			for (int i = 0; i < allPlanetsToDraw.length; i++) {
				String planetFileName = "images/" + allPlanetsToDraw[i].imgFileName;
				StdDraw.picture(allPlanetsToDraw[i].xxPos, allPlanetsToDraw[i].yyPos, planetFileName);
				StdDraw.show();
			}*/

			StdDraw.enableDoubleBuffering();

			for (double t = 0; t <= T; t += dt) {
				double[] xForces = new double[planets.length];
				double[] yForces = new double[planets.length];

				for (int i = 0; i < planets.length; i++) {
					
					xForces[i] = planets[i].calcNetForceExertedByX(planets);
					yForces[i] = planets[i].calcNetForceExertedByY(planets);
				}
				for (int i = 0; i < planets.length; i++) {
					planets[i].update(dt, xForces[i], yForces[i]);
				}
				StdDraw.setScale(-radius, radius);
			    StdDraw.clear();
			    StdDraw.picture(0,0, IMAGE_DIR + "/" + "starfield.jpg");
			    
			    for (int i = 0; i < planets.length; i++) {
					String planetFileName = IMAGE_DIR + "/" + planets[i].imgFileName;
					StdDraw.picture(planets[i].xxPos, planets[i].yyPos, planetFileName);
			    }
			    StdDraw.show();
				StdDraw.pause(10);
			}
			
			StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
		}

	}
}