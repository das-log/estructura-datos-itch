import java.util.Scanner;

public class ColorIntArgbMask {
    private short a;
    private short r;
    private short g;
    private short b;

    private short mAlpha;
    private short mRed;
    private short mGreen;
    private short mBlue;

    private final short mask = 0xFF;

    public ColorIntArgbMask(short a, short r, short g, short b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;

    }

    private String alpha() {
        mAlpha = (short) (mask & a);
        return Integer.toBinaryString(mAlpha);
    }

    private String red() {
        mRed = (short) (mask & r);
        return Integer.toBinaryString(mRed);
    }

    private String green() {
        mGreen = (short) (mask & g);
        return Integer.toBinaryString(mGreen);
    }

    private String blue() {
        mBlue = (short) (mask & b);
        return Integer.toBinaryString(mBlue);
    }

    @Override
    public String toString() {
        return String.format("ColorIntArgb [Alpha: %s, Red: %s, Green: %s, Blue: %s]",
                alpha(), red(), green(), blue());

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
do
        System.out.println("Ingrese nivel Alpha");
        short a = entrada.nextShort();
        System.out.println("Ingrese color Red");
        short r = entrada.nextShort();
        System.out.println("Ingrese color Green");
        short g = entrada.nextShort();
        System.out.println("Ingrese color Blue");
        short b = entrada.nextShort();
        entrada.close();

        ColorIntArgbMask bin = new ColorIntArgbMask(a, r, g, b);
        System.out.println(bin);
    }

}
