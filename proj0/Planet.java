public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;


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

    public double calcDistance(Planet p2) {
        double x_span = p2.xxPos - this.xxPos;
        double y_span = p2.yyPos - this.yyPos;

        double result_m = Math.pow(x_span, 2) + Math.pow(y_span, 2);
        return Math.sqrt(result_m);
    }

    public double calcForceExertedBy(Planet p2) {
        double dis = this.calcDistance(p2);
        double numerator = this.mass * p2.mass * 6.67E-11;
        double denominator = dis * dis;
        return numerator / denominator;
    }

    public double calcForceExertedByX(Planet p2) {
        double x_span = p2.xxPos - this.xxPos;
        return calcForceExertedBy(p2) * x_span / calcDistance(p2);
    }

    public double calcForceExertedByY(Planet p2) {
        double y_span = p2.yyPos - this.yyPos;
        return calcForceExertedBy(p2) * y_span / calcDistance(p2);
    }

    private boolean equals(Planet p2) {
        if (this == p2)
            return true;
        else
            return false;
    }

    public double calcNetForceExertedByX(Planet[] allplanets) {
        double sum_x = 0;
        for (Planet other : allplanets) {
            if (this == other)
                continue;
            sum_x += this.calcForceExertedByX(other);
        }
        return sum_x;
    }

    public double calcNetForceExertedByY(Planet[] allplanets) {
        double sum_y = 0;
        for (Planet other : allplanets) {
            if (this == other)
                continue;
            sum_y += this.calcForceExertedByY(other);
        }
        return sum_y;
    }

    public void update(double dt, double fx, double fy) {
        // calculate acceleration
        double acc_x = fx / mass;
        double acc_y = fy / mass;

        // calculate updated speed
        xxVel += acc_x * dt;
        yyVel += acc_y * dt;

        // calculate updated position with updated speed
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}


