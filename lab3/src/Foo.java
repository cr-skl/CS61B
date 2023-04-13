public class Foo {
public int x, y;

public Foo (int x, int y) {
this.x = x;
this.y = y;
}

public static void switcheroo (Foo a, Foo b) {
 Foo temp = a;
 a = b;
 b = temp;
 }

 public static void fliperoo (Foo a, Foo b) {
 Foo temp = new Foo(a.x, a.y);
 a.x = b.x;
 a.y = b.y;
 b.x = temp.x;
 b.y = temp.y;
 }

 public static void swaperoo (Foo a, Foo b) {
 Foo temp = a;
 a.x = b.x;
 a.y = b.y;
 b.x = temp.x;
 b.y = temp.y;
 }

 public static void main (String[] args) {
 Foo foobar = new Foo(10, 20);
 Foo baz = new Foo(30, 40);
 switcheroo(foobar, baz);
 StdOut.println("foobar x y is " + foobar.x +" " + foobar.y + " and baz x y is " + baz.x + " " + baz.y);
 fliperoo(foobar, baz);
 StdOut.println("foobar x y is " + foobar.x +" " + foobar.y + " and baz x y is " + baz.x + " " + baz.y);
 swaperoo(foobar, baz);
 StdOut.println("foobar x y is " + foobar.x +" " + foobar.y + " and baz x y is " + baz.x + " " + baz.y);
 }
}