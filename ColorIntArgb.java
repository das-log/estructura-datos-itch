import java.util.Scanner;

public class ColorIntArgb {
    private short a;
    private short r;
    private short g;
    private short b;

    private short shortAlpha;
    private short shortRed;
    private short shortGreen;
    private short shortBlue;

    public ColorIntArgb(short a, short r, short g, short b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;

        shortAlpha = 0;
        shortBlue = 0;
        shortGreen = 0;
        shortRed = 0;

    }

    private String alpha() {
        shortAlpha = (short) (shortAlpha | a);
        return Integer.toBinaryString(shortAlpha);
    }

    private String red() {
        shortRed = (short) (shortRed | r);
        return Integer.toBinaryString(shortRed);
    }

    private String green() {
        shortGreen = (short) (shortGreen | g);
        return Integer.toBinaryString(shortGreen);
    }

    private String blue() {
        shortBlue = (short) (shortBlue | b);
        return Integer.toBinaryString(shortBlue);
    }

    @Override
    public String toString() {
        return String.format("ColorIntArgb [Alpha: %s, Red: %s, Green: %s, Blue: %s]",
                alpha(), red(), green(), blue());
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nivel Alpha");
        short a = entrada.nextShort();
        System.out.println("Ingrese color Red");
        short r = entrada.nextShort();
        System.out.println("Ingrese color Green");
        short g = entrada.nextShort();
        System.out.println("Ingrese color Blue");
        short b = entrada.nextShort();
        entrada.close();

        ColorIntArgb bin = new ColorIntArgb(a, r, g, b);
        System.out.println(bin);
    }

}
