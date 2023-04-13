/**
 * Don't use extra library such as algs4.StdDraw,
 * just use the StdDraw within this file
 */
public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        int star_num = in.readInt();
        double uni_rad =  in.readDouble();
        return uni_rad;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int numPlanets = in.readInt();
        double uni_rad =  in.readDouble();

        Planet[] planets = new Planet[numPlanets];

        for(int i = 0; i < numPlanets; i++) {
            /** after initializing the  Object[],  we still have to intialize each Object , or
            * we will ger Error   as java.lang.NullPointerException since we don't allocate
             * actual place for these Objects
             */
            planets[i] = new Planet();

            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass = in.readDouble();
            planets[i].imgFileName = in.readString();
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        StdAudio.play("audio/2001.mid");
        for (int time = 0; time <= T; time += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                // do not update the positions until the whole calc of xForces and yForces are done
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            /**
             * 动画流程 ：0, setScale()  1，clear（） 2， picture() 3, show() 4,  pause()  然后循环
             */
            StdDraw.setScale(-radius, radius);
            // 1, clear()
            StdDraw.clear();
            // 2, picture()
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet i : planets) {
                i.draw();
            }
            // 3,show()
            StdDraw.show();
            // 4,pause()
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

