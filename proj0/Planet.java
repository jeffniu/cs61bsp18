public class Planet {
	
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		return Math.sqrt((p.xxPos - this.xxPos)*(p.xxPos - this.xxPos) + (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
	}

	public double calcForceExertedBy(Planet p) {
		if (equals(p)) {
			return 0;
		} else {
			return G * this.mass * p.mass / this.calcDistance(p) / this.calcDistance(p);
		}
	}

	public double calcForceExertedByX(Planet p) {
		if (equals(p)) {
			return 0;
		} else {
			return this.calcForceExertedBy(p) / this.calcDistance(p) * (p.xxPos - this.xxPos);
		}
	}

	public double calcForceExertedByY(Planet p) {
		if (equals(p)) {
			return 0;
		} else {
			return this.calcForceExertedBy(p) / this.calcDistance(p) * (p.yyPos - this. yyPos);
		}		
	}

	public double calcNetForceExertedByX(Planet[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i ++ ) {
			sum = sum + this.calcForceExertedByX(a[i]);
		}
		return sum;
	}

	public double calcNetForceExertedByY(Planet[] b) {
		double sum = 0;
		for (int i = 0; i < b.length; i ++ ) {
			sum = sum + this.calcForceExertedByY(b[i]);
		}
		return sum;
	}


}